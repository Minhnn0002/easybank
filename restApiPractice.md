# ✅ Best Practices khi Implement REST API trong Spring Boot

| STT | Best Practice               | Mô Tả Ngắn Gọn                                                                 |
|-----|-----------------------------|---------------------------------------------------------------------------------|
| 1   | ✅ Tuân thủ chuẩn RESTful     | Dùng đúng HTTP method (`GET`, `POST`, `PUT`, `DELETE`, ...) và URL rõ ràng     |
| 2   | ✅ Dùng DTO                  | Tránh expose entity trực tiếp, giúp bảo mật và dễ kiểm soát dữ liệu            |
| 3   | ✅ Xử lý lỗi toàn cục         | Dùng `@ControllerAdvice` và trả về thông điệp lỗi rõ ràng                      |
| 4   | ✅ Dùng đúng HTTP status code | 200, 201, 204, 400, 404, 500... theo đúng tình huống                            |
| 5   | ✅ Kiểm tra đầu vào           | Dùng `@Valid` + `@NotNull`, `@Size`,... để validate request                    |
| 6   | ✅ Phân trang, lọc, sắp xếp   | Hỗ trợ `page`, `size`, `sort`, `filter` để tối ưu hiệu năng                   |
| 7   | ✅ Chuẩn hóa response         | Dùng lớp `ApiResponse<T>` để trả dữ liệu theo format thống nhất               |
| 8   | ✅ Kiến trúc rõ ràng          | Tách riêng `controller`, `service`, `repository`, `dto`, `model`              |
| 9   | ✅ Swagger/OpenAPI           | Dùng để test và generate tài liệu API tự động                                  |
| 10  | ✅ Bảo mật API                | Dùng Spring Security + JWT, phân quyền bằng `@PreAuthorize`                   |
| 11  | ✅ Dùng đúng annotation       | `@RestController`, `@Service`, `@Repository` đúng mục đích                     |
