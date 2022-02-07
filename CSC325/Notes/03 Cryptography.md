# Cryptography

### Passive attack

- Does not affect the system resource and operation
- Eavesdropping, monitoring, ...
- Tried to obtain tramsmitted information
- Easy to protect
- Hard to detect

### Active attack

- Attemp to alter the system sources to affect operation

- Four categories
  - Replay
  - Masquerade 
  - Modification of message
  - Denial of Service
- Easy to detect 
- Hard to protect

# Symmetric Encryption

- Providing confidentiality
- Useful for transmitted and stored data
- Use only one key to encrypt or decrypt
- Aka. Conventional encryption (use for a long time)
- 2 requirements for secure use
  - Strong encryption algorithm
  - Sender and receiver must obtain same secret key in secure way and keep it secure

<img src="https://cdn.githubraw.com/thetkpark/csc-works/d0268304/CSC325/Notes/Images/Screen%20Shot%202565-02-07%20at%2013.58.12.png" alt="Screen Shot 2565-02-07 at 13.58.12" style="zoom:50%;" />

- Types of Ciphers (Most real cipher use both type)

  - **Substitution Cipher**

    - Subsitite one letter or bit for another in each place

      <img src="https://cdn.githubraw.com/thetkpark/csc-works/d0268304/CSC325/Notes/Images/Screen%20Shot%202565-02-07%20at%2014.02.54.png" alt="Screen Shot 2565-02-07 at 13.58.12" style="zoom:50%;" />

  - **Transposition Cipher**

    - Change position of the letter or bit
    - Does not change the individual letter or bit


## Attacking

### Cryptanalytic Attack

- A smarter way then brute-force, also faster

- Rely on 
  - Nature of the algorithm
  - Same knowledge of the general characteristic of the plaintext
  - Some sample of plaintext-ciphertext pairs
- Exploits the characteristics of the algorithm to deduce a specific plaintext or key being use

### Bruth-Force Attack

- Just try all possible keys
- Rely on computing power
- Can't protect -> Just use strong key and algorithm for protection

## Types of Symmetric Encryption

### Block Cipher

- Divided plaintext in to equal size block

- Process the input one block at a time

- Can resue key for blocks 

- Examples

  - DES

  - 3DES

  - AES


### Stream Cipher

- Process input elements continuously
- Process output one element at a time
- Encrypt plaintext at one byte at a time
- Like block cipher with one byte as block size
- Faster and less code
- Pseudorandom stream is one that generate unpredictable key stream without trace to of the input key
  - Can't generate same key stream without the key itself
- Example
  - RC4


<img src="https://cdn.githubraw.com/thetkpark/csc-works/d0268304/CSC325/Notes/Images/Screen%20Shot%202565-02-07%20at%2015.35.14.png" alt="Screen Shot 2565-02-07 at 15.35.14" style="zoom:50%;" />

> Stream Cipher example
>
> C = Cipher text, P = Plain text, K = key
>
> **Encryption**
>
> C = P `XOR` K 
>
> **Decryption**
>
> C `XOR` K = P `XOR` K `XOR` K = P `XOR` 0 = P

## Some Algorithms

- Triple DES (3DES)
  - Do DES for three times using two or three unique keys
  - Underlying encryption algorithm is the same as DES
  - 2^56 * 2^56 * 2^56 = 2^168 for using three keys
- AES (Advanced Encryption Standard)
  - Replacement for 3DES

## Practical Security Issues

- Typically symmetric encryption is applied to a unit of data larger than a single block
- Electronic cookbook (ECB) mode is the simplest approach to multiple-block encryption
  - Each block of plaintext is encrypted using the same key
  - Cryptanalysis may be able to exploit regularities in the plaintext

