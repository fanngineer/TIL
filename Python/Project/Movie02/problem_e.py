import requests
from pprint import pprint


def credits(title):
    # 영화 검색 D와 동일하게 id 추출
    try :
        URL = 'https://api.themoviedb.org/3/search/movie'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko',
            'query': title
        }
        response = requests.get(URL, params=params).json()
        movie = response['results'][0]
        movie_id = int(movie['id'])
    # 출연진, 연출진 데이터 조회
        URL2 = f'https://api.themoviedb.org/3/movie/{movie_id}/credits'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko'
        }
        response2 = requests.get(URL2, params=params).json()
        credits1 = response2['cast'] # 출연진 리스트 할당
        credits2 = response2['crew'] # 스태프 리스트 할당
        cast = [] # 조건에 맞는 출연진 리스트 생성
        directing = [] # 조건에 맞는 연출진 리스트 생성
        for i in credits1: # 출연진은 cast_id가 10 미만인 경우만 추출
            if i['cast_id']<10:
                cast.append(i['name'])
        for i in credits2: # 연출진은 부서가 Directing인 데이터만 추출
            if i['department'] == 'Directing':
                directing.append(i['name'])
        # Dictionary 형태의 credit 목록 반환
        Get_Credits = {'cast' : cast, 'directing' : directing}
        return Get_Credits
    # 검색이 불가능한 경우 None
    except :
        return None
# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    """
    제목에 해당하는 영화가 있으면 해당 영화 id를 통해 영화 상세정보를 검색하여 주연배우 목록(cast)과 스태프(crew) 중 연출진 목록을 반환
    영화 id 검색에 실패할 경우 None을 반환
    """
    pprint(credits('기생충'))
    # {'cast': ['Song Kang-ho', 'Lee Sun-kyun', ..., 'Jang Hye-jin'], 'crew': ['Bong Joon-ho', 'Park Hyun-cheol', ..., 'Yoon Young-woo']}
    pprint(credits('검색할 수 없는 영화'))
    # None
