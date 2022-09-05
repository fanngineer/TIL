import requests


def popular_count():
    URL = 'https://api.themoviedb.org/3/movie/popular?api_key=c8f63acafb8d64e6ecd6d44111b7ba2b&language=ko&page=1'
    # 인기 영화 목록 데이터 요청
    Get_Popular = requests.get(URL).json()
    #영화 목록 할당
    movies = Get_Popular['results']
    # 영화 목록의 개수 반환
    return len(movies)
    
# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    """
    popular 영화목록의 개수 반환
    """
    print(popular_count())
    # 20
