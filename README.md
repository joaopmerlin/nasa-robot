# Getting Started

### API Documentation

* `/rest/{robot}/{command}`

  Input
  ```
  {robot}    Name of robot
  {command}  List of commands, M (March), R (Right) and L (Left)
  ```

  Output: 
  ```
  {
    "x": 2,
    "y": 0,
    "point": "S"
  }
  ```
  
  Example: 
  ```
  curl -s --request POST http://localhost:8080/rest/mars/MMRMMRMM
  ```
