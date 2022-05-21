# IBM BPM Process

1. สร้าง Process App

2. สร้าง Processes แล้ว model ตัว BPMN ของ process

   - ถ้า activity นั้นต้องการ UI -> ใช้ User task
   - ไม่ต้องมี UI -> ใช้ In-line user task
   - Service task -> งานที่ server ทำ เกี่ยวข้องกับระบบ ต้องเลือก implementation (Service flow) ว่าจะให้ทำอะไร
   - Script task -> task ที่รัน javascript

3. สร้าง Business Data เพื่อใช้ในการเก็บข้อมูลที่ process ใช้

4. สร้าง private variable ให้กับข้อมูลที่เราต้องการจะใช้

5. ใส่ decision ให้กับ Exclusive gateway ที่เราสร้างไว้

   - เลือก default flow

   - ใช้ variable ที่เราต้องขึ้นในกาที่เราสร้างไว้

7. สร้าง Client-Side Human Service (ส่วนติดต่อผู้ใช้)

   - เพิ่ม Input และ Output variable ที่หน้านั้นจะใช้
     <img src="https://img.cscms.me/M8ijhAwtF6iRsPeJlGFU.png" alt="Screen Shot 2565-04-30 at 22.22.18" 
style="zoom: 33%;" />

   - เขียน process ในการทำงานของหน้า UI นั้นด้วย BPMN

     - ใช้ Coach ในการกำหนดหน้าต่างๆที่จะโชว์ให้ผู้ใช้เห็น 

     - Implement Coach (ใส่ Binding ด้วย)

     - โยงเส้นจาก Coach ว่ากดปุ่มไหน ไป activity ไหนต่อ

     - อย่าลืมใส่ Validation

       - การ Validate ใช้ Service activity

       - เช็ค error ได้จากการใช้ gateway 

         ```js
         tw.system. ![Screen Shot 2565-04-30 at 22.20.38](https://img.cscms.me/DOGNvZQteLo7cIV3bQNt.png)

   - สร้าง Service Flow ที่ทำหน้าที่ในการ validate 

     - เพิ่ม input variable เป็นข้อมูลต่างๆที่เราต้องการ validate (name, id, อะไรก็ว่าไป)

     - เพิ่ม output variable ชื่อ `coachValidation` เป็น type `CoachValidation`

     - เพิ่ม script task ใส่ script พวกนี้ลงไป

       ```js
       tw.local.coachValidation = new tw.object.CoachValidation()
       tw.local.coachValidation.validationErrors =
       	new tw.object.listOf.CoachValidationError()
       function checkString(value) {
       	return value != null && value == ""
       }
       function checkDate(value) {
       	var date = new TWDate()
       	return value == null || date.getDate() > value.getDate() // date ที่เลือกมาต้องมากกว่าปัจจุบัน 
ถ้าจะเอาน้อยกว่าก็กลับด้านเครื่องหมาย
       }
       
       // เช็คว่าตัวแปร name มีค่าในนั้นมั้ย
       if (checkString(tw.local.name)) {
       	tw.system.addCoachValidationError( // ไม่ต้องเปลี่ยน
       		tw.local.coachValidation, // ไม่ต้องเปลี่ยน
       		"tw.local.studentApplication.name", // ชื่อตัวแปรที่เราตั้งใน Client-Side Human Service
       		"Please enter your name." // error message เปลี่ยนได้
       	)
       }
       if (checkString(tw.local.id)) {
       	tw.system.addCoachValidationError(
       		tw.local.coachValidation,
       		"tw.local.studentApplication.id",
       		"Please enter your id."
       	)
       }
       ```

       ![Screen Shot 25p3wki85szW.png)

     - กลับไปที่ Client-Side Human Service แล้วทำไร Bind data เข้าไป (output ใช้เป็น 
`tw.system.coachValidation`)![Screen Shot 2565-04-30 at 
22.19.29](https://img.cscms.me/2KF9QorQQck9LGBKbxZH.png)

