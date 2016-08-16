#Design for TCCart 
=============
## Purpose of the system
To provide  design for TCCart, a Payment and Rewards Management System for Tea and Coffee Carts.

## Design
1. The PaymentSystem is composed by multiple modules. Each module is responsible for a specific responsibility. The PaymentSystem also uses ExternalLib to process certain tasks.
2. The CustomerRecordManager provides PaymentSystem ability to track customer status.
3. The TransactionRecordManager provides PaymentSystem ability to track transactions.
4. The EmailManager provides PaymentSystem ability to send emails to customer when purchase completes. The customer also gets email notification when he/her becomes VIP or gets rewards.
5. The PriceCalculator provides PaymentSystem ability to get the final cost of the purchase when the customer gets VIP discounts and/or uses his/her reward credits.
6. The PaymentSystem also has real world modules such as Customer, CreditCard, CustomerCard, VIP Status, Reward, and Transaction.



