# PROJECT_F
## 로맨스 영화 인기도 순위
### 평점 제공

import json
from pprint import pprint

def whatdoyouwant(movies, genres):
    # 입력창에 보여줄 장르 이름 리스트 할당
    genre_names = []
    for gr in genres:
        genre_names.append(gr['name'])
    # 사용자가 원하는 장르 입력
    while 1 :
        want = input(f'다음 장르중 원하는 장르를 검색하세요.\n{genre_names}\n >>>')
        # 입력된 장르의 아이디 찾기
        for genre in genres:
            if want == genre['name']:
                genre_id = genre['id'] ## 입력된 장르 이름이 같으면 아이디 할당
                break
        else : 
            print("해당 장르의 영화는 존재하지 않습니다.\n")
            continue ## 입력된 장르가 없는 경우 다시 입력
        break ## 입력된 장르가 존재하면 입력 중지
    # 장르 아이디에 해당하는 영화 목록 찾기
    wanted_movie = [] ## 원하는 영화 목록
    for movie in movies:
        grs = movie['genre_ids'] ##  각 영화의 장르  id리스트 불러오기
        for gr in grs :
            if genre_id == gr: ## 입력받은 장르와 아이디가 일치하면
                wanted_movie.append(movie) ## 원하는 영화 목록에 영화 정보 전부 저장
    # 원하는 영화 목록에서 모든 정보 중 원하는 정보만 추출
    new_wanted_list = []       
    for movie in wanted_movie:
        new_data = {
            'id': movie.get('id'),
            'title' : movie.get('title'),
            'poster_path' : movie.get('poster_path'),
            'vote_average' : movie.get('vote_average'),
            'overview' : movie.get('overview'),
        }
        new_wanted_list.append(new_data)
    
    return new_wanted_list  


# 파일 open 및 출력
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='utf-8')
    movies = json.load(movies_json)

    genres_json = open('data/genres.json', encoding='utf-8')
    genres_list = json.load(genres_json)

    pprint(whatdoyouwant(movies, genres_list))
