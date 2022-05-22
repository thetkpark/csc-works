# Quantitative Process Analysis

## Performance measure

- Time
- Cost
- Quality
- Flexibility

## Flow Analysis

- Analysis based on the flow of the process

### Cycle Time

- A time between start and end of the process or activity
- เวลาที่ใช้ในการทำงานของ process หรือ activity นั้นๆ
- 2 Types of cycle time
  1. Process time ` เวลาที่ใช้ทำงานจริงๆ`
  2. Waiting time `เวลาที่ต้องรอ`

#### Simple

<img src="https://img.cscms.me/PCJdYy9gcmV4pShWtjeC.png" alt="Screen Shot 2565-05-20 at 23.30.21" style="zoom: 25%;" />

>  Cycle time = 10 + 20 = 30

#### XOR Gateway

<img src="https://img.cscms.me/mdzP054bmanquE4diDia.png" alt="Screen Shot 2565-05-20 at 23.33.00" style="zoom: 25%;" />

<img src="https://img.cscms.me/NKXim9OtWCK0UIRbQL45.png" alt="Screen Shot 2565-05-20 at 23.33.31" style="zoom:35%;" />

> เอา probability กับ cycle time ของเส้นทางนั้นมาคูณกัน แล้วค่อยจับทุก path ที่แยกออกจาก XOR มาบวกกัน
>
> Cycle time = 10 + ((0.5 * 20) + (0.5 * 10)) = 25

#### AND Gateway

<img src="https://img.cscms.me/MxAcd8BDsIdHoH1El6G0.png" alt="Screen Shot 2565-05-20 at 23.35.00" style="zoom:25%;" />

<img src="https://img.cscms.me/3VNgiQabNUIcYvWmC74N.png" alt="Screen Shot 2565-05-20 at 23.37.34" style="zoom:33%;" />

> คิดจาก Path ที่มี cycle time มากที่สุด
>
> Cycle time = 10 + MAX(20,10) = 10 + 20 = 30

#### Loop

<img src="https://img.cscms.me/ReZqaWBHV2h2Ampc2sc6.png" alt="Screen Shot 2565-05-20 at 23.38.27" style="zoom:25%;" />

<img src="https://img.cscms.me/LKJgIbRvYSu8JCr3rO8l.png" alt="Screen Shot 2565-05-20 at 23.38.54" style="zoom:33%;" />

> ตามสูตรเลย
>
> Cycle time = 10 + (20 / 1 - 0.2) = 10 + 25 = 35

### Cycle Time Efficiency

- Ratio of **actual process time `CT`** compare to **theoretical process time `TCT`**
- อัตราส่วนระหว่างเวลาที่ใช้ในการทำ process จริงๆ กับเวลาที่ใช้ในทางทฤษฎี
- ค่าใกล้ 1 `ดีอยู่แล้ว ไม่ค่อยมีอะไรให้ปรับปรุง`
- ค่าใกล้ 0 `มีให้ปรับปรุงเยอะ`
<img src="https://img.cscms.me/H4d4eqe6sInIpvmizXH0.png" alt="Screen Shot 2565-05-21 at 12.39.42" style="zoom:50%;" />

---

### Cycle Time and Work-In-Process

#### Work-In-Process `WIP`

- Average number of instance of process that are active a given point of time
- จำนวนเฉลี่ยของ process ที่กำลังทำงานอยู่ในช่วงเวลานั้นๆ
  - จำนวนลูกค้าเฉลี่ยในช่วงนั้น (ถ้า process ของเราคือการบริการลูกค้า)

#### Arrival Rate `λ`

- Average number of new instances of the process that are created per time unit
- จำนวนเฉลี่ยของ process ที่ถูกสร้างขึ้นมาใหม่ในหนึ่งหน่วยเวลา
  - จำนวนลูกค้าที่เข้าร้านต่อหนึ่งหน่วยเวลา (Ex: 10 คน/ชั่วโมง)

<img src="https://img.cscms.me/DiXLjH4c8BX7diMtj7c3.png" alt="Screen Shot 2565-05-21 at 12.56.30" style="zoom:50%;" />

#### Example

>A restaurant receives on average 1,200 customers per day (between 10am and 10pm). During peak times (12pm to 3pm and 6pm to 9pm), the restaurant receives around 900 customers in total and, on average, 90 customers can be found in the restaurant at a given point in time. At non-peak times, the restaurant receives 300 customers in total and, on average, 30 customers can be found in the restaurant at a given point in time.

> ##### What is the average time that a customer spends in the restaurant during peak times?
>
> average time that a customer spends คือต้องการหา Cycle time
>
> 900 customers in total of 6 hours -> 900 / 6 = 150 customer / hour -> λ = 150
>
> WIP = 90 (จาก  90 customers can be found in the restaurant at a given point in time)
>
> From WIP = λ x CT
>
> 90 = 150 x CT
>
> CT = 0.6 hour

> ##### What is the average time that a customer spends in the restaurant during non-peak times?
>
> หา Cycle time เหมือนเดิม
>
> 300 customers in total of 6 hours -> 300 / 6 = 50 customer / hour -> λ = 50
>
> WIP = 30 (จาก  30 customers can be found in the restaurant at a given point in time)
>
> From WIP = λ x CT
>
> 30 = 50 x CT
>
> CT = 0.6 hour

### Flow analysis summary

- Can also be used to calculate cost (Not just time)
  - Most of calculation are the same
  - Cost of AND block is the summation of all activities in the block

---

## Queues

- Mathematical techniques to analyze systems that have resource contention
- Two modes of queue
  - **Single-queue system (M/M/1)**
    - First-In-First-Out (FIFO) queue
    - Only 1 server
    - คิวจ่ายเงินที่มี counter เดียว
  - **Multiple-queue system (M/M/c)**
    - Same as M/M/1 but multiple server
    - มีหลาย counter จ่ายเงิน -> หลายแถว

#### Arrival Rate `λ`

- Average number of new instances of the process that are created per time unit
- จำนวนเฉลี่ยของ process ที่ถูกสร้างขึ้นมาใหม่ในหนึ่งหน่วยเวลา

#### `μ`

- Mean number of customers that can be served per time unit
- จำนวนลูกค้าเฉลี่ยที่พนักงานสามารถรับได้ในหนึ่งหน่วยเวลา

#### Occupation rate `ρ`

- How busy the server is
- พนักงานยุ่งขนาดไหน
- **M/M/1**
  - ρ = λ / μ
- **M/M/c**
  - ρ = λ / ( c x μ )

### Computable parameter

#### Average number of jobs (e.g. customer) in the queue `Lq`

- จำนวนลูกค้าเฉลี่ยในคิว

<img src="https://img.cscms.me/DRsMBpP1RdKm4LhPaDhG.png" alt="Screen Shot 2565-05-21 at 22.11.40" style="zoom: 33%;" />

#### Average time one job spends in the queue `Wq`

- เวลาที่ลูกค้ารอในคิว

	<img src="https://img.cscms.me/FD4szrfNM87qhzHbXbO3.png" alt="Screen Shot 2565-05-21 at 22.14.02" style="zoom: 33%;" />

#### Average time one job spends in the system `W`

- time in queue + time in service
	
	<img src="https://img.cscms.me/shoOMmbLMNswaNZTC8KY.png" alt="Screen Shot 2565-05-21 at 22.16.20" style="zoom: 33%;" />

#### Average number of jobs in the system `L`
- Same as Work-In-Progress `WIP`

  <img src="https://img.cscms.me/xKIFGNhUNxrJfxrIfPug.png" alt="Screen Shot 2565-05-21 at 22.18.24" style="zoom: 33%;" />
### Example

> A company designs electronic hardware for a range of customers in the high-tech electronics industry. The company receives order for designing a new circuit every 20 working days on average. It takes a team of engineers on average 10 working days to design a hardware. Assume that the arrival of requests follows a Poisson process and the request is handled FIFO. Use working day as a time unit.

> `The company receives order for designing a new circuit every 20 working days on average` 
>
> - 1 order / 20 working day 
> - 0.05 order / working day 
> - λ = 0.05
>
> `It takes a team of engineers on average 10 working days to design a hardware`
>
> - 1 order / 10 working day
> - 0.1 order / working day
> - μ = 0.1
>
> `Assume that the arrival of requests follows a Poisson process and the request is handled FIFO`
>
> - This is **M/M/1**
>
> `Find Occupation rate ρ`
>
> - ρ = λ / μ = 0.05 / 0.1 = 0.5
>
> `Find Lq`
>
> - Lq = ρ^2 / (1-ρ) = 0.5 * 0.5 / 0.5 = 0.5
>
> `Find Wq`
>
> - Wq = Lq / λ = 0.5 / 0.05 = 10
>
> `Find W`
>
> - W = Wq + (1/μ) = 10 + 10 = 20
>
> `Find L`
>
> - L = λ x W = 0.05 x 20 = 1

---

# Process Monitoring and Control

> The information about process execution is prepared and analyzed to provide a feedback loop

- สิ่งทุกอย่างที่เกิดขึ้นจะอยู่ใน Log 

## Automatic Process Discovery with α-Algorithm

> Find the process model from event log

![Screen Shot 2565-05-22 at 13.36.33](https://img.cscms.me/FadCbAud6PRUwpB3xQlc.png)

### Activities Relation in α-Algorithm

- **Basic**
  - `a` > `b`
  - Activity `a` is directly followed by `b`
- **Causality**
  - `a` -> `b`
  - Activity is always `a` directly followed by `b`
- **Potential parallelism**
  - `a` || `b`
  - When `a > b` and `b > a`
- **No direct succession**
  - `a` # `b`
  - When `a ≯ b` and `b ≯ a`

### Steps

> Two cases of event log
>
> <a,b,g,h,j,k,i,l> and <a,c,d,e,f,g,j,h,i,k,l>

#### 1. Find All activities relationship (Basic, Causality, and Potential parallelism)

- Basic relations

  <img src="https://img.cscms.me/E6IicHKMH1GJpNIiPqXj.png" alt="Screen Shot 2565-05-22 at 13.46.56" style="zoom: 33%;" />

- Causal relations

<img src="https://img.cscms.me/KbxV3Fe87Hkno3EbohtK.png" alt="Screen Shot 2565-05-22 at 13.47.23" style="zoom:33%;" />

- Potential parallelism
  - `h||j` and `k||i`
- No direct succession
  - All the remaining

#### 2. Create the relations matrix

<img src="https://img.cscms.me/HWJz6DYaYNxjKm7SIHdI.png" alt="Screen Shot 2565-05-22 at 13.48.43" style="zoom:33%;" />

#### 3. Identify Tasks

- All tasks `TL` (Task/activity ทั้งหมดที่มี)

- First task `TI` (Task ที่เริ่มต้น ดูจากหน้าของแต่ล่ะ log มีกี่ตัวก็เขียนลงไปใน set)

- Last task `TO `(Task สุดท้าย ดูจากท้ายของ log มีกี่ตัวก็เขียนลงไปใน set)

  <img src="https://img.cscms.me/Hq8tbUYgpfX1V3Pa8JOK.png" alt="Screen Shot 2565-05-22 at 13.54.15" style="zoom: 33%;" />

#### 4. Identify sets of all relations

- 3 Patterns to identify
  1. `a` -> `b`
  2. `a` -> (`b` # `c`)
     - `a` -> `b`
     - `a` -> `c`
     - `b` # `c`
     - ดูตารางในตาม row (แนวนอน) ว่ามีลูกคร -> สองอันรึเปล่า แล้วทำการเช็ค `#`
  3.  (`b` # `c`) -> `a` 
     - `b` -> `a`
     - `c` -> `a`
     - `b` # `c`
     - ดูตารางในตาม column (แนวตั้ง) ว่ามีลูกศร -> สองอันรึเปล่า แล้วทำการเช็ค `#`

<img src="https://img.cscms.me/bPEjMBMxMjz3Sc4WhdaY.png" alt="Screen Shot 2565-05-22 at 13.59.33" style="zoom: 33%;" />

#### 5. Eliminate duplicate relations

- If there is `a` -> (`b` # `c`) eliminate `a` -> `b` and  `a` -> `c`

- If there is (`b` # `c`) -> `a`  eliminate `b` -> `a` and  `c` -> `a`

<img src="https://img.cscms.me/S41KHLfXEWPcIk5aczSf.png" alt="Screen Shot 2565-05-22 at 14.01.33" style="zoom:33%;" />

#### 6. Connet the start and end event

##### Start Event

- If there is only one activity in `TI`, connet it to start end
- If there are many activities in `TI`, use XOR or AND based on their relationship
  - No direct succession use **XOR**
  - Potential parallelism use **AND**

##### End Event

- For each activities in `TO` connect each of them to end event

  <img src="https://img.cscms.me/E0rBfKzI9iqglMyHKwJk.png" alt="Screen Shot 2565-05-22 at 14.06.25" style="zoom:33%;" />

#### 7. Connect the rest of the flow

##### `a` -> `b`

> Connect them directly

<img src="/Users/thetkpark/Library/Application Support/typora-user-images/Screen Shot 2565-05-22 at 14.07.54.png" alt="Screen Shot 2565-05-22 at 14.07.54" style="zoom:33%;" />

##### `a` -> (`b` # `c`) 

> Draw from flows  
>
> - `a` to XOR
> - XOR to `b` and `c`

<img src="https://img.cscms.me/wWOnE8vIE75HXP2I8eqV.png" alt="Screen Shot 2565-05-22 at 14.09.28" style="zoom:33%;" />

##### (`b` # `c`) -> `a` 

> Draw from flows  
> - `b` and `c` to XOR
> - XOR to `a`

<img src="https://img.cscms.me/QoGjUrV1FA9fKJnfYeca.png" alt="Screen Shot 2565-05-22 at 14.53.00" style="zoom:33%;" />

##### Multiple incoming or outgoing path

- Use `AND`  to split or join the path

<img src="https://img.cscms.me/NpLEy9gEW19EjbZw6b4X.png" alt="Screen Shot 2565-05-22 at 14.54.08" style="zoom:33%;" />

---

## Performance Analysis

### Cost 

Find the total cost per case

#### Example

> - BuildIT has 250 actual working days / year of 8 hours
>- Health insurance and pension 20% of their salary
> - 10 days sick leave on average / year
> 1. “Submit equipment rental request” is conducted by the site engineer. It takes the engineer 20 minutes to fill in the form on paper. The site engineer gets an annual salary of €60,000.
> 1. The clerk receives the form and selects suitable equipment and checks the availability. Both activities together take 15 minutes. The clerk works at an annual rate of €40,000.
>1. The works engineer reviews the rental request (annual salary of €50,000). This review takes 10 minutes.
> 1. The clerk is also responsible for sending a confirmation including a purchase Order for renting the equipment, which takes 30 minutes.
>

> 1. **Cost of site engineer**
>    - 60,000 * 120/100 = 72,000 euro includes insurance and pension
>    - 72,000 / (250 - 10) = 300 euro / working day (deduct the average sick leave)
>    - 300 / 8 = 37.5 euro / working hour
>    - 37.5 / 60 = `0.625 euro / working minute`
> 2. **Cost of clerk**
>    - 40,000 * 120/100 = 48,000 euro includes insurance and pension
>    - 48,000 / (250 - 10) = 200 euro / working day (deduct the average sick leave)
>    - 200 / 8 = 25 euro / working hour
>    - 25 / 60 = `0.417 euro / working minute`
> 3. **Cost of work engineer**
>    - 50,000 * 120/100 = 60,000 euro includes insurance and pension
>    - 60,000 / (250 - 10) = 250 euro / working day (deduct the average sick leave)
>    - 250 / 8 = 31.25 euro / working hour
>    - 31.25 / 60 = `0.52 euro / working minute`
>
> **Total Cost**
>
> (0.625 * 20) + (0.417 * (15 + 30)) + (0.52 * 10) = `36.465 euro / case`

### Quality

> Calcualte from repetition probability (การทำอะไรซ้ำๆ) 
>
> - CT = Cycle time เฉลี่ยของทุก case
> - T = Cycle time เฉลี่ยของ task
>
> <img src="/Users/thetkpark/Library/Application Support/typora-user-images/Screen Shot 2565-05-22 at 15.25.25.png" alt="Screen Shot 2565-05-22 at 15.25.25" style="zoom:33%;" />

#### Example

> Consider the five cases in which we observe the following execution times for task a: 
>
> 1. 5 minutes, 10 minutes. 
> 2. 10 minutes. 
> 3. 20 minutes, 6 minutes, 10 minutes. 
> 4. 5 minutes.
> 5. 10 minutes, 10 minutes.
>
> Find the probability of repetition (r)

> **Sum of all cycle time** = 5 + 10 + 10 + 20 + 6 + 10 + 5 + 10 + 10 = 86 minutes
>
> **CT** = 86 / 5 = 17.2 minutes
>
> **T** = 86 / 9 = 9.56 minutes
>
> r = 1 - (T/CT) = 1 - (9.56 / 17.2) = 1 - 0.56 = 0.44



### Flexibility

> Calculate from Degree of optional `OPT`
>
> - Topt คือจำนวน tasks ที่ไม่ได้อยู่ใน log ของทุก case
> - T คือจำนวน tasks ที่อยู่ใน log ทั้งหมด (ไม่เอาตัวซ้ำ)
>
> <img src="https://img.cscms.me/f54SUTbhB8bZSREJXg0v.png" alt="Screen Shot 2565-05-22 at 15.31.25" style="zoom:33%;" />

#### Example

> Consider the following cases
>
> 1. <a,b,c,d>
> 2. <a,b,d,c,e,f>
> 3. <a,c,d,e,f>
> 4. <a,b,c,d,e,f>
> 5. <a,c,d,e,f>
>
> Calculate the degree of optionality, if c, d are concurrent

> **Tasks ที่ไม่อยู่ในทุก log** = { b, e, f }
>
> **Task ทั้งหมด** = { a, b, c, d, e, f }
>
> OPT = 3 / 6 = 0.5

---

## Conformance Checking

> Conformance แปลว่า ความสอดคล้อง
>
> เช็คความสอดคล้องกันระหว่าง log (การทำงานจริง) กับ process model ที่คิดไว้
>
> ใช้การทำ Log replay และคิดค่า Fitness (เข้าใกล้ 1 ก็คือยิ่งดี)
>
> <img src="https://img.cscms.me/QPHHoRcg3mkjbIxHMTHk.png" alt="Screen Shot 2565-05-22 at 15.37.01" style="zoom: 40%;" />
>
> - `p`: number of tokens that are **correctly produced**
> - `c`: number of tokens that are **correctly consumed**
> - `m`: number of tokens that are **missing** for executing the next activity in the log
> - `r`: number of tokens remaining **unconsumed** after executing the final activity in the log

> เช็คค่า `p`, `c`, `m`, `r` ไปตามลูกศร ว่า token ที่ออกมาจากสิ่งก่อนหน้า ถูกใช้ (มี task อยู่ใน log) โดยสิ่งด้านหลังรึเปล่า

> <img src="/Users/thetkpark/Library/Application Support/typora-user-images/Screen Shot 2565-05-22 at 15.48.18.png" alt="Screen Shot 2565-05-22 at 15.48.18" style="zoom:40%;" />
>
> - Message event สร้าง token ออกมาหนึ่งอัน (`p` = 1)
> - Task a ใช้ token นั้นไป เนื่องจากเราเจอว่ามี task a อยู่ใน log (`c` = 1)
>
> ---
>
> - Task a สร้าง token ออกมา (`p` = 1)
> - XOR gateway ใช้ token นั้นไป (`c` = 1)
>
> ---
>
> - XOR gateway สร้าง token ออกมา 1 อัน (`p` = 1)
> - Task b ใช้ token นั้นไป เพราะเราเจอ task b ใน log (`c` = 1)

> <img src="/Users/thetkpark/Library/Application Support/typora-user-images/Screen Shot 2565-05-22 at 15.51.21.png" alt="Screen Shot 2565-05-22 at 15.51.21" style="zoom:40%;" />
>
> - XOR gateway สร้าง token ออกมา 1 อัน (`p` = 1)
> - Task g ไม่ได้ใช้ token นั้น เพราะเราไม่เจอ task g ใน log 
>   - Token ถูกสร้างขึ้นมา 1 อัน แต่ไม่ได้ใช้ (`r` = 1)
>
> ---

> <img src="https://img.cscms.me/JWts5XO3p4AXskwGFAco.png" alt="Screen Shot 2565-05-22 at 15.53.43" style="zoom:40%;" />
>
> - AND gateway ใช้ 1 token (`c` = 1)
> - Task g ไม่ได้ทำงาน เพราะเราไม่เจอมันใน log แต่ XOR gateway ใช้ 1 token
>   - Token ถูกใช้ไป 1 แต่ว่าไม่มีใครสร้าง (เพราะ g ไม่ได้ทำงาน) (`m` = 1)
>
> ---

<img src="https://img.cscms.me/NGntkv5AFFFbVayfCfh2.png" alt="Screen Shot 2565-05-22 at 15.55.39" style="zoom:50%;" />

นับจำนวน `p`, `c`, `m`, `r` ทั้งหมด แล้วแทนในสูตรหา fitness
