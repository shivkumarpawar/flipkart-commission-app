import java.util.List;

public class AffiliateSystem {
    private List<Order> orders;
    private List<CommissionRule> commissionRules;
    private List<Transaction> transactions;
    public AffiliateSystem(List<Order> orders, List<CommissionRule> commissionRules, List<Transaction> transactions) {
        this.orders = orders;
        this.commissionRules = commissionRules;
        this.transactions = transactions;
    }

    // Order order = new Order("123456", 100.0, "PROD123", "Mobiles", "AFF001", new Date(), OrderState.CREATED);

    public void handleOrderEvent(String orderId, OrderState newState){
        try {
            Order order = getOrderById(orderId);

            if(order == null){
                return;
            }
            switch (newState) {
                case CANCELED: 
                    
                case RETURNED:
                    cancelCommission(order);
                    break;
                case RETURN_PERIOD_EXPIRED:
                    calculateAndAddCommission(order);
                    break;
            
                default:
                    break;
        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    private void calculateAndAddCommission(Order order){
        try {
            CommissionRule rule = getCommissionRuleByCategory(order.getCategoryId());
        
            if(rule!= null){
                double commission = calculateAndAddCommission(order, rule);
                addToPendingTransactions(order, commission);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void cancelCommission(Order order){
        try {
            transactions.forEach(transaction -> {
                if(transactionContainsOrder(transaction,order)){
                    transaction.removeOrder(order);
                    transaction.updateTotalAmountPaid(-getCommissionForOrder(order));
    
                }
            });
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    private double calculateAndAddCommission(Order order, commissionRule rule){
        try {
            if(rule.getPrecentage()>0){
                return Math.min(order.getPrice()*rule.getPrecentage()/100, rule.getMaxCap());
            } else{
                return rule.getFlatRate();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private void addToPendingTransactions(Order order, double commission){
        try {
            Transaction pendingTransaction = findPendingTransaction();
            if(pendingTransaction == null || pendingTransaction.getTotalAmountPaid() + commission > = 100){
                pendingTransaction = createPendingTransaction(); 
            }
            pendingTransaction.addOrder(order, commission);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private Transaction findPendingTransaction(){
        try {
            return transactions.stream()
                           .filter(transaction - > transaction.isEmpty() || transaction.getTotalAmountPaid() < = 100)
                           .findFirst().orElse(null);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
                        
    }

    private Order getOrderById(String orderId){
        try {
            for(Order order : orders){
                if(order.getOrderId().equals(orderId)){
                    return order;
                }
            }
            return null;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private CommissionRule getCommissionRuleByCategory(String categoryId){
        try {
            for(CommissionRule rule : commissionRules){
                if(rule.getCategory().equals(categoryId)){
                    return rule;
                }
            }
            return null;
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        

    }

    private double getCommissionForOrder(Order order){
        try {
            CommissionRule rule = getCommissionRuleByCategory(order.getCategoryId());
            if(rule!=null){
                if(rule.getPrecentage()>0){
                    return Math.min(order.getPrice()*rule.getPrecentage()/100, rule.getMaxCap());
    
                }else{
                    return rule.getFlatRate();
                }
            }
            return 0.0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    private String getTransactionsForAffiliate(String transactionId){

        return transactionId;
    }

    private String getTransactionsForAffiliate(String transactionId){

        return transactionId;
    }

    

    
}
