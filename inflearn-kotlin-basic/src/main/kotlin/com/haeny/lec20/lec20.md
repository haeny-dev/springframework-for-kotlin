### Lec 20. 코틀린의 scope function

`1. scope function 이란 무엇인가?`
- scope function: 일시적인 영역을 형성하는 함수
  - 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나,
  - method chaning 에 활용하는 함수를 scope function 이라고 합니다.

`2. scope function 의 분류`

|    구분    |   it   |  this  |
|:--------:|:------:|:------:|
|  람다의 결과  |  let   |  run   |
| 객체 그 자체  |  also  | apply  |
- this: 생략이 가능한 대신, 다른 이름을 붙일 수 없다.
- it: 생량이 불가능한 대신, 다른 이름을 붙일 수 있다.

- with(파라미터, 람다)
  - 확장함수가 아님
  - this 를 사용해 접근하고, this는 생략 가능하다.

`3. 언제 어떤 scope function 을 사용해야 할까?`
- let
  - 하나 이상의 함수를 call chain 결과로 호출할 때

`4. scope function 과 가독성`