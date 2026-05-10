# Restaurant Management System (RMS) API

Chào mừng bạn đến với hệ thống quản lý nhà hàng (Restaurant Management System). Dự án này được xây dựng trên nền tảng Spring Boot, cung cấp các API để quản lý thực đơn, đặt bàn và vận hành nhà hàng.

## 📌 Tài liệu API
Bạn có thể xem chi tiết các endpoint, tham số truyền vào và ví dụ phản hồi tại:
👉 **[Postman API Documentation](https://documenter.getpostman.com/view/42687295/2sBXqMHeSK)**

---

## 🛠 Yêu cầu hệ thống
* **Java SDK:** 17
* **Hệ quản trị CSDL:** PostgreSQL
* **Công cụ build:** Gradle

---

## 🚀 Hướng dẫn cài đặt & Chạy ứng dụng

### 1. Cấu hình môi trường
* Đảm bảo bạn đã cài đặt PostgreSQL và tạo một database mới.
* Chỉnh sửa file `src/main/resources/application.yml` với thông tin kết nối database của bạn (xem mẫu bên dưới).

### 2. Chạy ứng dụng trên Windows
Mở terminal (PowerShell hoặc Command Prompt) tại thư mục gốc của dự án và chạy lệnh:

```bash
.\gradlew bootRun
