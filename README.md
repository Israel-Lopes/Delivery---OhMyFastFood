# Oh my delivery

## Navigation flow
![Navigation Flow](https://github.com/Israel-Lopes/Delivery---OhMyFastFood/blob/master/templates/navigation_flow.png)

## Entity relationship model
![Navigation Flow](https://github.com/Israel-Lopes/Delivery---OhMyFastFood/blob/master/templates/navigation_flow.png)

## Routes
### /users
user      | value
--------- | ------
id        | Long
name      | String
email     | String
passwor   | String
address   | String
cpf       | String

### /product
product   | value
--------- | ------
id        | Long
name      | String
price     | double

### /cart
cart      | value
--------- | ------
id        | Long
Product   | Object

