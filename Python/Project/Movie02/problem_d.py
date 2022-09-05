import requests
from pprint import pprint


def recommendation(title):
    #영화 검색
    try :
        # 요청할 API 주소
        URL = 'https://api.themoviedb.org/3/search/movie'
        # 사용될 parameter들, 입력한 영화 제목을 할당
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko',
            'query': title   
        }
        # 데이터 요청
        response = requests.get(URL, params=params).json()
        # 검색 결과의 첫번째 영화 정보 추출
        movie = response['results'][0]
        # 영화 id 추출
        movie_id = int(movie['id'])
        #영화 추천 목록 데이터 수집
        URL2 = f'https://api.themoviedb.org/3/movie/{movie_id}/recommendations'
        params = {
            'api_key': 'c8f63acafb8d64e6ecd6d44111b7ba2b',
            'language' : 'ko'
        }
        response2 = requests.get(URL2, params=params).json()    
        recos = response2['results']
        # 영화 추천 목록에서 영화 제목 데이터 리스트 추출
        Get_Recommendations = list(m['title'] for m in recos)
    # 검색 불가능 시 None 리턴
    except :
        return None
    # 이상 없을 시 추천 영화 목록 리턴
    return Get_Recommendations
# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    """
    제목에 해당하는 영화가 있으면 해당 영화의 id를 기반으로 추천 영화 목록 구성
    추천 영화가 없을 경우 []를 반환
    영화 id 검색에 실패할 경우 None을 반환
    (주의) 추천 영화의 경우 아래 예시 출력과 차이가 있을 수 있음
    """
    pprint(recommendation('기생충'))
    # ['조커', '1917', '조조 래빗', ..생략.., '살인의 추억', '펄프 픽션']
    pprint(recommendation('그래비티'))
    # []
    pprint(recommendation('검색할 수 없는 영화'))
    # None
