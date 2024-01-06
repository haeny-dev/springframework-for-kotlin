### Lec 19. 코틀린의 이모저모

`1. Type Alias 와 as import`
- Type Alias
  - 긴 이름의 클래스 혹은 함수 타입이 있을 때 축약하거나 더 좋은 이름을 쓰고 싶다 할 때 사용할 수 있음.
- as import
  - 다른 패키지의 같은 이름 할수를 동시에 가져오고 싶을 때 사용
  - 어떤 클래스나 함수를 임포트 할 때 이름을 바꾸는 기능

`2. 구조분해와 componentN 함수`
- 구조분해
  - 복합적인 값을 분해하여 여러 변수를 한 번에 초기화하는 것

`3. Jump 와 Label`
- Label
  - 특정 expression에 라벨이름@ 을 붙여 하나의 라벨로 간주하고 break, continue, return 등을 사용하는기능

`4. TakeIf 와 TakeUnless`
- TakeIf
  - 주어진 조건을 만족하면 그 값이, 그렇지 않으면 null이 반환된다.
- TakeUnless
  - 주어진 조건을 만족하지 않으면 그 값이 반환되고 그렇지 않으면 null이 반환된다.