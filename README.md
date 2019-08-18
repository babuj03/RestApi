# RestApi

Using Rest api with DB Mocking implemented with below three Operation using spring boot.

1 get all phone numbers
2 get all phone numbers of a single customer
3 activate a phone number

PhoneServiceTest used to test the above three methods.



Swagger API Details info

http://localhost:8080/swagger-ui.html#/phone-resource


API URL info

/api/v1/phone/{phoneId}
/api/v1/phone/activate/{phoneId}
/api/v1/phone/phone-by-customerId/{customerId}
