# Affiliate System

This is a Java program for managing an affiliate system, where affiliates earn commissions for orders placed through their referral links on Flipkart. The program allows for handling orders, commission rules, transactions, and order events.

## Usage

### Input

Inputs can be provided through STDIN (standard input). The program expects the following inputs:

1. **Orders**: Order details including orderId, price, productId, categoryId, affiliateId, timestamp, and state.
2. **Commission Rules**: Commission rules including category, percentage, maxCap, and flatRate.

Example input format:

Order: {orderId} {price} {productId} {categoryId} {affiliateId} {timestamp} {state}
Commission Rule: {category} {percentage} {maxCap} {flatRate}



### Output

Outputs are written to STDOUT (standard output) and provide transaction details, including transaction ID, order IDs, associated commissions, and total amount paid.

Example output format:

Transaction ID: {transactionId}
Order ID: {orderId}, Commission: {commission}
Total Amount Paid: {totalAmountPaid}



### Running the Program

Compile and run the `AffiliateSystemDriver` class. Ensure that input is provided through STDIN and that output is directed to STDOUT.

```bash
javac AffiliateSystemDriver.java
java AffiliateSystemDriver < input.txt > output.txt

License
This project is licensed under the MIT License - see the LICENSE file for details.