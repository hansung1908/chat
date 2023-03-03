# chat

rdbms는 테이블 간의 중복을 없애기 위해 서로 테이블 공유하는 기술로 각 테이블의 고유 id를 부여하여 이를 통해 서로 공유하는 기술로 중복이 없고 데이터 변경이 쉽다는 장점이 있지만
데이터를 찾을 때 여러 테이블을 타기 때문에 성능면에서 아쉬움이 있다.

mongodb는 스크립트 형태로 정보들을 저장하며 각 스크립트에 중복되는 정보도 포함되어있어 데이터 검색시 훌륭한 성능을 보여주어 많은 데이터를 짧은 시간에 처리할 수 있지만 각 스크립트
간의 중복이 많아 일관성 유지가 힘들어 데이터 변경이 힘들다.

그래서 채팅 서버에 경우 유저의 수가 증가할수록 채팅 데이터는 그 이상으로 증가하기에 많은 데이터를 단기간에 처리할 수 있는 mongodb가 적합하다.

본래 서블릿 기반 스프링 서버는 스레드를 생성하여 각 요청을 처리하다보니 순서대로 처리하기엔 사용자가 증가할수록 서버에 엄청난 부담이 되어 time slicing을 통해 두개의 다른 동작을
시간 단위로 쪼개어 반복해서 처리하는 방법(context switching) 이 나왔지만 처리 시간이 오래걸려 큰 성능개선을 느끼긴 힘들다.

비동기 netty 서버는 스프링 최신 버전에 쓰이는 서버로 스레드 하나로 대기열을 만들어 각 요청을 처리하며 서버가 쉬는 시간에 대기열에 있는 응답들을 반환해주는 방식으로 반복 처리로 인한
시간 손실을 없애서 빠른 처리 속도를 기대할 수 있다.

앞서 설명한 처리 속도에 강점이 있는 비동기 서버와 mongodb를 함께 사용하여 빠른 응답이 필요한 서비스에서 유용하게 활용할 수 있다.
