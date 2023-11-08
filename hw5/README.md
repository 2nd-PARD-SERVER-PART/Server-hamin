<h1>HW5</h1>
로그인 가능한 유저별 블로그 만들기

---

<h2>Sign Up</h2>
<img width="1419" alt="signup1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/6ae8226c-3b20-4bc8-9301-eeb58dc4c2cc">
<img width="1422" alt="signup2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/ab66d4ad-e5a1-4e77-8189-c1dd071d0668">
유저 이름, 이메일, 비밀번호를 입력하면 회원가입을 한다.

---

<h2>Sign In</h2>
<img width="1417" alt="signin1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/8edf3718-271e-40f9-a4c4-5b84cb089c00">
<img width="1393" alt="signin2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/607cf190-792e-44a0-946f-d0c64a0cd09a">
유저의 이메일과 비밀번호를 입력하면 로그인을 한다.
엑세스 토큰과 유저의 정보를 알려준다.

---

<h2>Create Posting</h2>
<img width="1410" alt="createPosting1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/9bf51511-5219-4928-9967-2a9f0ecef1ec">
<img width="1391" alt="createPosting2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/21c89846-b17e-4ce4-a2a3-6e6f7b576865">
유저가 자신의 포스팅을 작성 할 수 있다.
포스팅 정보에는 유저의 이름과 이메일 정보가 포함된다.

<h2>Read Posting</h2>
<img width="1409" alt="getPosting1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/47e32550-8e1d-4fc6-ab25-8d340a844c57">
<img width="1386" alt="getPosting2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/8f4a3684-1a5c-41ce-bf7d-a15ba8538e90">
유저가 쓴 포스팅을 조회 할 수 있다.
자신의 포스팅이 아니더라도 로그인만 하면 어느 포스팅이더라도 조회 할 수 있다.

<img width="1427" alt="getAllPosting" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/7a56717b-6c69-430f-b035-5068780e9da8">


```json
{
  "result": true,
  "message": "Successfully get all posting.",
  "data": [
    {
      "id": 1,
      "postingName": "첫번째 포스팅",
      "postingContent": "change content",
      "timestamp": "2023-11-08T12:44:28.647+00:00",
      "userResponseDto": {
        "id": 1,
        "userName": "서하민",
        "userEmail": "shmshm86@naver.com"
      }
    },
    {
      "id": 2,
      "postingName": "Second posting",
      "postingContent": "coffee",
      "timestamp": "2023-11-08T12:46:10.169+00:00",
      "userResponseDto": {
        "id": 1,
        "userName": "서하민",
        "userEmail": "shmshm86@naver.com"
      }
    },
    {
      "id": 3,
      "postingName": "test user first",
      "postingContent": "I am test user",
      "timestamp": "2023-11-08T12:47:30.309+00:00",
      "userResponseDto": {
        "id": 2,
        "userName": "test user",
        "userEmail": "test@gmail.a"
      }
    },
    {
      "id": 4,
      "postingName": "test 2",
      "postingContent": "테스트 2",
      "timestamp": "2023-11-08T12:47:44.250+00:00",
      "userResponseDto": {
        "id": 2,
        "userName": "test user",
        "userEmail": "test@gmail.a"
      }
    },
    {
      "id": 5,
      "postingName": "세번째 테스트",
      "postingContent": "third test",
      "timestamp": "2023-11-08T12:48:01.094+00:00",
      "userResponseDto": {
        "id": 2,
        "userName": "test user",
        "userEmail": "test@gmail.a"
      }
    }
  ]
}
```

전체 포스팅 목록을 조회 할 수 있다.

<h2>Update Posting</h2>
<img width="1422" alt="updatePosting1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/f31314de-7fbe-4989-ad84-2e198dae4487">
<img width="1408" alt="updatePosting2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/b7f612ef-8232-4b41-99f4-2246695c113d">
자신이 쓴 포스팅의 정보를 수정 할 수 있다.

<h2>Delete Posting</h2>
<img width="1430" alt="deletePosting" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/f29fd2f7-d42d-4208-9252-92a98a828919">
자신이 작성한 포스팅을 삭제 할 수 있다.

<img width="1395" alt="afterDeletePosting" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/c0200631-4b5d-42ac-8eea-4436ff9544ae">
유저 정보에서 자신이 쓴 글 목록에서 삭제한 아이디가 2인 포스팅이 사라진 것을 확인 할 수 있다.

---

<h2>Read User</h2>
<img width="1431" alt="getUser1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/f53163da-56cf-4ad7-8a19-20c2bc53e3d5">
<img width="1393" alt="getUser2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/2e0911d5-cf7e-44d2-95c1-81ce0095c1ff">
유저가 자신의 정보를 조회할 수 있다.

<img width="1393" alt="getUserError" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/30b4fb01-c1f8-4339-899c-daf2e2cf5b4b">
다른 사람의 정보를 조회할 순 없다.

<br>

<img width="1421" alt="getAllUser" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/d63d366d-99bd-4f3f-a6d4-7d228bdcd1fa">


```json
{
  "result": true,
  "message": "Successfully get all user.",
  "data": [
    {
      "id": 1,
      "userName": "Seo Hamin",
      "userEmail": "shmshm86@naver.com",
      "postingList": [
        {
          "id": 1,
          "postingName": "첫번째 포스팅",
          "postingUploadDate": "2023-11-08T12:44:28.647+00:00"
        },
        {
          "id": 2,
          "postingName": "Second posting",
          "postingUploadDate": "2023-11-08T12:46:10.169+00:00"
        }
      ],
      "signUpDate": "2023-11-08T12:41:21.337+00:00"
    },
    {
      "id": 2,
      "userName": "test user",
      "userEmail": "test@gmail.a",
      "postingList": [
        {
          "id": 3,
          "postingName": "test user first",
          "postingUploadDate": "2023-11-08T12:47:30.309+00:00"
        },
        {
          "id": 4,
          "postingName": "test 2",
          "postingUploadDate": "2023-11-08T12:47:44.250+00:00"
        },
        {
          "id": 5,
          "postingName": "세번째 테스트",
          "postingUploadDate": "2023-11-08T12:48:01.094+00:00"
        }
      ],
      "signUpDate": "2023-11-08T12:46:33.653+00:00"
    }
  ]
}
```

유저 전체의 정보를 조회 할 수 있다.


<h2>Update User</h2>
<img width="1431" alt="updateUser1" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/f387b1e9-539a-428e-86a8-52b9cab82156">
<img width="1418" alt="updateUser2" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/4d5d9ff2-2b30-4feb-b391-000c262eeb3a">
유저가 자신의 정보를 수정 할 수 있다.

<h2>Delete User</h2>
<img width="1430" alt="deleteUser" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/2bd6ed4a-e352-4afe-9781-21859886f224">
유저가 탈퇴를 할 수 있다.

<img width="1410" alt="afterDeleteUser" src="https://github.com/2nd-PARD-SERVER-PART/Server-hamin/assets/87740197/d28fde30-ec87-40d0-b87a-7d3733fd5563">
전체 포스팅을 조회 했을 때 탈퇴한 아이디가 2인 유저의 글은 삭제 되어 나오지 않는 것을 확인 할 수 있다.



---
