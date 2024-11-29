join을 하려면 mybatis를 필수로 사용해야함

- BUILD.GRADDLE에 의존성 추가
- MYBATIS를 사용해야함
- itemMapper 를 만들어서 insert를 직접 적어주어야함
- itme xml을 만들어서 insert를 직접 적어서 해줘야함

241127
- 개발자 간의 약속 : 하나의 매서드에는 하나의 기능만 = solid 원칙

- RequestParam : html의 name 속성을 가진것들을 서버에서 사용하려면, query string 으로 보낸 데이터 사용,
input 태그가 100만개라면 @RequestParam Map input 이런식으로 사용 가능
- @PathVariable : url parmeter로 보낸 데이터를 사용하려면
- @ModelAttribute : html의 name 속성을 가진것들을 바로 object로 변환하려면(생략 가능)
- @RequestBody : ajax body로 보낸 데이터를 서버에서 사용하려면(Post 방식만 가능 따라서 그냥
- @ExceptionHandler(Exception.class) : 모든 API의 에러를 캐치하려면
- @PreAuthorize("isAuthenticated()") : 로그인 여부
- @PreAuthorize("isAnonymous()") : 로그아웃 여부
- @PreAuthorize("hasAuthority('어쩌구')") : 어쩌구 권한이면 true 아니면 false