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

#### Arrival Time `λ`

- Same as in the cycle time

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
---

# Process Monitoring and Control

