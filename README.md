# Simple-RESTapi-Spring
Simple RESTapi Spring Project (Basit RESTapi Spring Projesi)

# Author: Hakan Cem Gerçek

# Proje içerikleri:

- appConfig                  --> Employee, Department ve Salary için 'dummy' veriler listeleri.
    - AppConfig              --> Veritabanı harici config dosyasında tutulan 'dummy' veriler.
- model(Entity)              --> Projedeki entity'lerin bulunduğu paket.
    - Employee               --> Çalışan class'ı.
    - Department             --> Department class'ı.
    - Salary                 --> Salary class'ı.
- controller                 --> controller katmanı paketi.
    - EmployeeController     --> Çalışan class'ı için RESTController bean'i.
    - DepartmentController   --> Department class'ı için RESTController bean'i.
    - SalaryController       --> Salary class'ı için RESTController bean'i.
- service                    --> service katmanı paketi.
    - EmployeeService        --> Employe class'ı için Service bean'i.
    - DepartmentService      --> Department class'ı için Service bean'i.
    - SalaryService          --> Salary class'ı için Service bean'i.
- repository                 --> repository katmanı paketi.
    - EmployeeRepository     --> Employee class'ı için Repository bean'i.
    - DepartmentRepository   --> Department class'ı için Repository bean'i.
    - SalaryRepository       --> Salary class'ı için Repository bean'i.
