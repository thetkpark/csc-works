# Hadoop

- Built for working in cluster (Many servers)
- Work with MapReduce paradigm

## HDFS

- Hadoop **Distributed** File System![Screen Shot 2564-11-30 at 23.03.23](/Users/thetkpark/Desktop/Screen Shot 2564-11-30 at 23.03.23.png)
- File is devided into blocks
- Each block is replicate and store on difference server

**There are 2 types of node/server in HDFS**

1. Namenode
   - Contact point for the client to perform operation
   - Like a master
2. Datanode
   - Store the blocks

Note: Read and write operation are describe in the slides page 8 and 9

## MapReduce

There are 2 phase of operation

1. **Mapping**
   - Process the input and output in key/value format
   - Can be done parallelly by dividing the data
   - The input is read from HDFS
   - The output is store in local file system
   - `Partitioning keys` is used to determine which output go to which reducer (Hash partitioning is commonly used)
   - Same key go to same reducer
2. **Reducing**
   - Process and merge the value with associated key
   - Write the output to HDFS

## Yarn

- Resource manager on Hadoop

- Divided server's resource into one or more `containers`

- Each container has some CPU and some memory

  Has 3 main conponent

  1. **Global Resource Manager (RM)**
     - Manage global scheduling
  2. **Node Manager (NM)** on each server
     - Manage its own server
  3. **Application Master (AM)** of each application/job/task
     - Talk with RM and NM for container to run the job
     - Detect job failure

# Blockchain

- Basically a Distributed Ledger Technology
- Based on distributed P2P

## Ledger

- Account book or สมุดบัญชี
- Record all the transactions
- What is written should not be edited
- It's a `truth` (อะไรที่เขียนอยู่เป็น `สัจนิรันดร์`)

## Ledger to Blockchain

- The ledger is represented by a `blocks`

- Each block contains `transactions` and `block header` (Information of the block)

- Once the block is created and accept by the system, the data in the block is the `truth`

- The block cannot be edited ❌

- The blocks are distributed to everyone in the system

- Everyone can read, audit, and create new block (by mining)

  ![csc371-blockchain (anno)-32](/Users/thetkpark/Desktop/csc371-blockchain (anno)-32.png)

  ### Block Header

  Some important fields in header of each block
  
  - Height: the block number
  - Timestamp
  - **Previous block**: The hash of previous block 
    - It create the link to previous block and so on... 
    - When connected together -> Form a chain of block (That's why it's called blockchain)
  - Hash: The hash of this block
    - Changing thing in the block cause hash value to change dramatically -> Prevent block modification
  - Nonce: Random value (Look at the mining section)

## 3 Major Type of Blockchain

1. **Public Blockchain**

   - No one control the system
   - Anyone can read/write/audit the data on the blockchain

2. **Private Blockchain**

   - There is a one who in charge (Who read/write the data)
   - Private property of an individual or an organization

   - Have access control
   - Not very decentralized (In my opinion)

3. **Consortium or Federated Blockchain**

   - One or more are in charge
   - Used among individual or organization
     - Ex: Blockchain network for logistics process
   - Also has access control

## Mining (Create a new block)

- The process is difference by consensus algorithms
- **Consensus Problem:** Whose block is the valid one / Who gonna create the block

### Proof of Work (PoW)

- "Given the math problem, who can solve it can create the block"
- **The problem:** Find the nonce value such that it will make the hash value of the block less than some value
- **The solution:** Bruthfoce, just every value 
- The difficulty (target value) can be adjust to retain consistent block creation time
  - Bitcoin has block time of around 10 minute
  - If the time to solve is too fast -> Increate difficulty
  - Too slow -> Decrease diffculty
- The process of bruthforcing for finding the correct nonce is `mining`
- The block creator or the winner will received coins (Ex: Bitcoin) as a reward
- Very computing intensive
- The most decentralized consensus algorithm

### Proof of Stake (PoS)

- Stake into the pool or วางเงินลงไปในกองกลาง
- More money -> More probabllity to win (create the block)
- Received transaction fee as a reward
- No need to compute anything -> More efficiency than PoW

## Forking
[![Blockchain Forks Explained - Good Audience](https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcdn-images-1.medium.com%2Fmax%2F2400%2F1*iy8AQhBp7lC-1sxYpsZAJQ.png&f=1&nofb=1)](https://cdn-images-1.medium.com/max/2400/1*iy8AQhBp7lC-1sxYpsZAJQ.png)

- The chain is split

## Bitcoin Wallet

Wallet is generated using cryptography

1. User generate asymmetric key pair (Public key and Private key)
2. `Wallet Address` is generated from public key

## Example of Bitcoin Transaction Flow

> Alice want to transfer 0.1 BTC to Bob

1. Alice create transaction with include the destination address and amount
2. Alice signs the transaction with her private key (Digital signature)
3. The transaction, signature, and her her public key are sent to node in the network
4. Miner (Node) received the transaction and added into mempool (Temporary storage for new transactions)
5. The miner pick transactions from mempool and added to the block
   - Transaction with heighest fee likely to be picked first (ทุนนิยม)
6. The miner find the nonce value that make hash of that block match the target value (Proof of Work process)
7. If it found that value, then propogates the new block to the network. 
8. All the miner verify the new block. If no problem -> Added to the chain
9. When the new block the created and accepted by the network, Bob can see 0.1 BTC in his wallet

**Note:** The validity of transaction can be verify by digital signature and public key

## Ethereum

- Want to be "world computer"
- Coin is called `Ethereum (ETH)`
- **User can run code on it** with `smart contract`
- The code is run with EVM (Ethereum Virtual Machine)

### Smart Contract

- It's a code that user can interact with (Send money to, Invoke a function on the contract)

- Everything is transparant due to characteristic of blockchain

  **Example**

  - Lottery smart contract: People put money into the smart constract and it will determine the winner

