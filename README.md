# BasicHTTPServer

A straightforward library to start a basic HTTP server with configurable routes and responses.  
Routes and their behaviors can be easily defined through JSON parameters, enabling quick setup for redirections, static responses, cookies, and more.

## How It Works

With this library, you can define both the **routes** and their corresponding **behaviors**. For instance:

### Example Configuration

- The root route (`/`) redirects to `/cnoe0` and establishes the cookie:  
  `sessionId=abc123; Path=/; HttpOnly`.

- Route `/cnoe0` redirects to `/cnoe1` and sets the same cookie:  
  `sessionId=abc123; Path=/; HttpOnly`.

- Route `/cnoe1` redirects to `/cnoe2` with the same cookie:  
  `sessionId=abc123; Path=/; HttpOnly`.

- Route `/cnoe2` redirects to `/cnoe3` and again sets the cookie:  
  `sessionId=abc123; Path=/; HttpOnly`.

- Finally, route `/cnoe3` responds with `200 OK` and a JSON body:
  ```json
  {
    "cnoe": "body"
  }

![img.png](img.png)