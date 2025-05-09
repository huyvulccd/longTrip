# **📑 README DỰ ÁN**
# **HỆ THỐNG ĐẶT VÉ XE**

## **1. Giới thiệu dự án**

### **1.1 Mô tả dự án**

Hệ thống đặt vé xe là một nền tảng giúp người dùng tìm kiếm, đặt vé xe khách trực tuyến một cách thuận tiện. Nhà xe có thể quản lý xe, chỗ ngồi, thông tin đặt vé, và gửi thông báo cho khách hàng.

### **1.2 Công nghệ sử dụng**

- **Backend:** Spring Boot, RabbitMQ, Redis, WebSocket.
- **Frontend:** React/Vue (dành cho User & Nhà xe).
- **Database:** MySQL, Redis (caching).
- **Message Queue:** RabbitMQ để xử lý email.
- **Notification:** Firebase Cloud Messaging (FCM), Twilio/Viettel SMS API.

---

## **2. Phạm vi và chức năng chính**

### **2.1 Site User**

- [ ]  Đăng nhập: Sử dụng email hoặc số điện thoại.
- [ ]  Tìm kiếm chuyến xe: Hỗ trợ trên cả web và mobile.
- [ ]  Xem chi tiết chuyến đi & ghế trống.
- [ ]  Đặt xe & Thanh toán: Chọn ghế, đặt vé, thanh toán trực tuyến.
- [ ]  Nhận thông báo: Về chuyến đi, nhắc nhở trước giờ khởi hành.

### **2.2 Site Nhà Xe**

- [ ]  Đăng nhập: Admin có tài khoản root để tạo tài khoản nhân viên.
- [ ]  Quản lý xe, chỗ ngồi: Cập nhật thông tin chuyến xe, số ghế trống.
- [ ]  Nhận thông báo: Khi có khách đặt vé.
- [ ]  Gửi thông báo cho khách: Khi có thay đổi về chuyến xe.
- [ ]  Xem báo cáo doanh thu, số lượng vé đã bán.

---

## **3. Các giai đoạn triển khai (Phases)**

### **📌 Phase 1: Xây dựng chức năng cốt lõi**

### **1️⃣ Hoàn thiện luồng đặt vé**

- [ ]  API đặt vé: Người dùng chọn tuyến xe, ghế ngồi, và tiến hành đặt vé.
- [ ]  Thanh toán: Tích hợp cổng thanh toán trực tuyến.
- [ ]  Gửi email xác nhận: Sau khi đặt vé thành công.

### **2️⃣ Quản lý chuyến xe & trạng thái ghế**

- [ ]  Admin cập nhật danh sách xe, số ghế.
- [ ]  Hiển thị ghế trống trên giao diện user.

---

### **📌 Phase 2: Tối ưu hiệu suất với RabbitMQ & Redis**

### **1️⃣ RabbitMQ – Gửi email bất đồng bộ**

- [ ]  Producer (Booking Service): Đẩy email vào hàng đợi.
- [ ]  Consumer (Email Service): Xử lý hàng đợi và gửi email.
- [ ]  Tối ưu: Dead Letter Queue, Delayed Queue, Persistence Mode.

### **2️⃣ Redis – Caching dữ liệu**

- [ ]  Cache danh sách tuyến xe: Giảm truy vấn MySQL.
- [ ]  Cache trạng thái ghế: Giảm tải DB khi nhiều user xem chỗ ngồi.
- [ ]  Tối ưu: Dùng TTL, Pub/Sub để cập nhật cache tự động.
- [ ]  **Kết quả:** Hệ thống chạy nhanh hơn, không bị quá tải khi có nhiều user đặt vé cùng lúc.

---

### **📌 Phase 3: Tối ưu & Mở rộng**

### **1️⃣ Cập nhật trạng thái ghế real-time với WebSocket**

- [ ]  Spring Boot WebSocket: Gửi update real-time khi có người đặt vé.
- [ ]  Frontend kết nối WebSocket để nhận dữ liệu mới ngay lập tức.

### **2️⃣ Báo cáo doanh thu cho nhà xe**

- [ ]  Thống kê số lượng vé đã bán theo ngày/tháng.
- [ ]  Hiển thị doanh thu & tỷ lệ lấp đầy ghế.
- [ ]  Tối ưu truy vấn bằng Materialized View hoặc Redis cache.

### **3️⃣ Cải thiện hệ thống thông báo**

- [ ]  Firebase Cloud Messaging (FCM) cho push notification.
- [ ]  Twilio/Viettel SMS API để gửi tin nhắn SMS.
- [ ]  Tùy chọn nhận thông báo: email, SMS, push notification.
- [ ]  **Kết quả:** Người dùng nhận thông tin kịp thời, giúp trải nghiệm tốt hơn.

---

## **4. Kết quả & Lợi ích**

### **📌 Đối với User**

- [ ]  Đặt vé nhanh, giao diện dễ sử dụng.
- [ ]  Nhận thông báo về chuyến đi.
- [ ]  Không bị đặt trùng ghế (cập nhật real-time).

### **📌 Đối với Nhà xe**

- [ ]  Quản lý chuyến xe và ghế hiệu quả hơn.
- [ ]  Giảm tải cho hệ thống nhờ caching & message queue.
- [ ]  Báo cáo doanh thu rõ ràng, giúp ra quyết định nhanh hơn.

### **📌 Về hiệu suất hệ thống**

- [ ]  Giảm tải DB: Redis cache giúp truy vấn nhanh hơn.
- [ ]  Tăng tốc API: RabbitMQ xử lý email bất đồng bộ.
- [ ]  Cập nhật dữ liệu tức thì: WebSocket giúp ghế trống được cập nhật real-time.

---

## **5. Hướng phát triển tiếp theo**

- [ ]  Tích hợp NoSQL (MongoDB) để lưu dữ liệu lịch sử đặt vé.
- [ ]  Mở rộng sang mô hình bán vé xe liên tỉnh hoặc xe hợp đồng.
- [ ]  Phát triển mobile app (React Native / Flutter).
- [ ]  Tích hợp AI để gợi ý tuyến xe dựa trên hành vi người dùng.

---

# **📌 Kết luận**

Hệ thống đặt vé xe đã được xây dựng với hiệu suất cao, khả năng mở rộng tốt và trải nghiệm người dùng mượt mà. Các công nghệ như **RabbitMQ, Redis, WebSocket** giúp tối ưu hiệu suất, giảm tải hệ thống, và đảm bảo user luôn có trải nghiệm tốt nhất. 🚀

🔥 **Dự án đã hoàn thành tốt 3 phases và sẵn sàng mở rộng trong tương lai!** 🔥

---

## **5. Cấu Trúc Cơ Sở Dữ Liệu (Database Design)**

Hệ thống sử dụng **SQL (MySQL hoặc PostgreSQL)** để lưu trữ dữ liệu chính. Dưới đây là thiết kế database:

### **5.1. Bảng Người Dùng (`users`)**

Lưu thông tin khách hàng và nhân viên nhà xe.

| **Trường** | **Kiểu Dữ Liệu** | **Mô Tả** |
| --- | --- | --- |
| `id` | BIGINT (PK) | ID người dùng |
| `name` | VARCHAR(255) | Họ và tên |
| `email` | VARCHAR(255) | Email (có thể null) |
| `phone_number` | VARCHAR(20) | Số điện thoại (bắt buộc) |
| `password` | VARCHAR(255) | Mật khẩu đã mã hóa (dùng nếu không đăng nhập bằng OTP) |
| `role` | ENUM | `USER`, `DRIVER`, `ADMIN` |
| `created_at` | TIMESTAMP | Thời gian tạo tài khoản |

🔹 **OTP login:** Nếu người dùng đăng nhập bằng OTP, mật khẩu (`password`) có thể để trống.

🔹 **Lưu token đăng nhập:** Nếu đăng nhập bằng mật khẩu, token sẽ có hạn sử dụng **1 tuần**.

---

### **5.2. Bảng Chuyến Đi (`trips`)**

Lưu thông tin các chuyến xe.

| **Trường** | **Kiểu Dữ Liệu** | **Mô Tả** |
| --- | --- | --- |
| `id` | BIGINT (PK) | ID chuyến đi |
| `bus_id` | BIGINT (FK) | ID xe chạy chuyến này |
| `departure` | VARCHAR(255) | Điểm xuất phát |
| `destination` | VARCHAR(255) | Điểm đến |
| `departure_time` | TIMESTAMP | Thời gian khởi hành |
| `status` | ENUM | `AVAILABLE`, `ONGOING`, `FINISHED` |

🔹 **Redis cache**: Danh sách chuyến đi có thể được cache để giảm tải database.

---

### **5.3. Bảng Xe (`buses`)**

Lưu thông tin xe khách.

| **Trường** | **Kiểu Dữ Liệu** | **Mô Tả** |
| --- | --- | --- |
| `id` | BIGINT (PK) | ID xe |
| `license_plate` | VARCHAR(20) | Biển số xe |
| `capacity` | INT | Số ghế |

---

### **5.4. Bảng Ghế Ngồi (`seats`)**

Lưu thông tin ghế ngồi trên xe.

| **Trường** | **Kiểu Dữ Liệu** | **Mô Tả** |
| --- | --- | --- |
| `id` | BIGINT (PK) | ID ghế |
| `bus_id` | BIGINT (FK) | Xe thuộc ghế này |
| `seat_number` | VARCHAR(10) | Số ghế |

🔹 **Redis cache**: Trạng thái ghế còn trống có thể cache trong **5 phút**.

---

### **5.5. Bảng Đặt Vé (`bookings`)**

Lưu thông tin đặt vé của khách.

| **Trường** | **Kiểu Dữ Liệu** | **Mô Tả** |
| --- | --- | --- |
| `id` | BIGINT (PK) | ID đặt vé |
| `user_id` | BIGINT (FK) | Người đặt vé |
| `trip_id` | BIGINT (FK) | Chuyến đi |
| `seat_id` | BIGINT (FK) | Ghế đã đặt |
| `status` | ENUM | `PENDING`, `CONFIRMED`, `CANCELLED` |
| `created_at` | TIMESTAMP | Thời gian đặt vé |

🔹 **RabbitMQ:** Sau khi đặt vé, hệ thống gửi tin nhắn xác nhận email qua **RabbitMQ**.

---

## **6. Redis vs RabbitMQ - Cách Lưu Trữ & Ứng Dụng**

### **6.1. Redis - Lưu Trữ Dữ Liệu Tạm Thời (Cache & Session)**

Redis là **cơ sở dữ liệu NoSQL dạng key-value**, thường được dùng để cache dữ liệu và lưu session người dùng.

### **Kiểu Dữ Liệu Trong Redis**

| **Kiểu Dữ Liệu** | **Ví Dụ Dùng** |
| --- | --- |
| **String** | Lưu token đăng nhập, OTP |
| **Hash** | Lưu thông tin người dùng, chuyến xe |
| **List** | Lưu thông báo gửi đến user |
|  |  |

### **Redis Trong Hệ Thống Đặt Vé Xe**

- **Cache danh sách chuyến đi**:
    
    ```
    shell
    Sao chépChỉnh sửa
    SET trips_cache "list_of_trips" EX 600  # Cache 10 phút
    
    ```
    
- **Lưu OTP đăng nhập** (hết hạn sau 5 phút):
    
    ```
    shell
    Sao chépChỉnh sửa
    SET otp:123456 "987654" EX 300  # OTP có hạn 5 phút
    
    ```
    
- **Lưu trạng thái ghế còn trống** (reset sau 5 phút):
    
    ```
    shell
    Sao chépChỉnh sửa
    SET available_seats:trip_123 "A1,A2,A3" EX 300
    
    ```
    

---

### **3.2. RabbitMQ - Message Queue (Hàng Đợi Xử Lý Tác Vụ)**

RabbitMQ dùng để **gửi thông điệp bất đồng bộ giữa các dịch vụ**.

### **RabbitMQ Trong Hệ Thống Đặt Vé Xe**

| **Tác Vụ** | **Queue** |
| --- | --- |
| Gửi email xác nhận đặt vé | `email_queue` |
| Gửi thông báo trước giờ đi | `notification_queue` |
| Ghi log sự kiện | `log_queue` |

### **Ví Dụ RabbitMQ Trong Hệ Thống**

- Khi user đặt vé, hệ thống **gửi tin nhắn vào queue**:
    
    ```python
    python
    Sao chépChỉnh sửa
    channel.basic_publish(exchange='',
                          routing_key='email_queue',
                          body='{"user_id": 123, "trip_id": 456}')
    
    ```
    
- Consumer nhận tin nhắn và gửi email:
    
    ```python
    python
    Sao chépChỉnh sửa
    def send_email(ch, method, properties, body):
        data = json.loads(body)
        print(f"Sending email to user {data['user_id']} for trip {data['trip_id']}")
    
    ```
    

---
