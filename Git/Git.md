# Git 이란?
- 분산 버전 관리 프로그램
- 버전관리 => 레포트_최종본>레포트_진짜최종>레포트_진짜진짜최종>...
- 분산 <-> 중앙 집중
## Git lab, Github
Git 기반의 저장소 서비스를 제공하는 서버
- Gitlab - 저장하는 서버를 제공, 폐쇄적
- Github - 공개적
## CLI <-> GUI
- CLI : Command-Line Interface : 컴퓨터한테 명령을 내리는 방법
- Graphical User Interface : 단계가 많고, 컴퓨터의 성능을 많이 소요

# Git 사용법
## 기본 명령어
- touch : 파일 생성 명령어
- Mkdir : 새 폴더를 생성하는 명령어
- ls : 현재 작업 중인 디렉토리의 파일들을 보는 명령어
- rm : 지우기 (폴더에 뭐가 있으면 안지워짐)
rm -r :을 통해서 재귀적으로 삭제
- cd 폴더이름 : 현재 작업중인 디렉토리를 변경하는 명령어
- cd .. 이전 폴더 (.은 현재 폴더을 의미, ..은 부모 폴더를 의미)
- start . 현재 위치 열기

## 경로
- 절대경로 : 루트 디렉토리부터 목적지점까지 모든 경로 작성한 것(-C:/Users/ssafy/desktop)  
- 상대경로 : 현재 작업하고 있는 위치를 기준으로 상대적 위치(./ : 현재 작업하고 있는 폴더, ../ : 현재 작업하고 있는 폴더의 부모 폴더)

## Git 기본 개념
Readme.md : 프로젝트에 대한 전반적인 설명  
Repository : 특정 디렉토리를 버전 관리하는 저장소  
특정 버전으로 남긴다 = commit한다.
- 커밋은 working directory(내가 작업하고 있는 실제 디렉토리= del),   staging area(커밋으로 남기고싶은, 특정버전으로 관리하고 싶은 파일(변경파일들)이 있는 곳(커밋하기전에)())   repository(커밋들이 저장되는 곳=.git) 3가지 영역으로 동작
- local repository 컴퓨터
- remote repository 서버 (github)

## Git 명령어
- git init : 로컬 저장소 생성
.git 디렉토리에 버전 관리에 필요한 모든 것이 들어있음
- git add : working directory에서 staging area로 변경사항을 저장
- git commit : staging area에 있는 파일을 통해 repository에 commit이 저장  
staging area에 보관되었던 변경사항이 파일로 commit에 저장( 최종 파일을 저장하는 것이 아님!)
working directory로 보내서 file을 modified로 변경
- git status : 현재 git으로 관리되고 있는 파일들의 상태를 알 수 있다.
- git log : 현재 branch의 commit이력
- git diff : git diff 앞4자리 앞 4자리
- git remote add origin {remote_repo}
- git push -u origin master
- git clone {remote_repo} : remote repo를 local로 복사
- git pull :  remote 의 변경사항 local로 불러오기




