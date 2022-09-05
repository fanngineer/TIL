import json
from pprint import pprint


def movie_info(movies, genres):
    pass 
    # 여기에 코드를 작성합니다.  
    #데이터 추출
    new_datas = []
    for movie in movies:
        new_data = {
            'id': movie.get('id'),
            'title' : movie.get('title'),
            'poster_path' : movie.get('poster_path'),
            'vote_average' : movie.get('vote_average'),
            'overview' : movie.get('overview'),
            'genre_ids' : movie.get('genre_ids'),
        }
        #'genre_names':'genre_ids_value' 추가
        new_data['genre_names'] = new_data['genre_ids']
        #기존 'genre_ids':'genre_ids_value' 지우기
        del new_data['genre_ids']
        #'genre_names':'genre_names_value'
        gn = [] #genre names list
        for j in new_data['genre_names']: #id값 하나씩 찾기
            for i in genres: #id와 일치하는 이름 찾기
                if j == i['id']:
                    gn.append(i['name']) # genre name list에 id일치하는 name 할당
        new_data['genre_names'] = gn # genre_names_value에 gn할당
        new_datas.append(new_data)
    return new_datas    
        
# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='utf-8')
    movies_list = json.load(movies_json)

    genres_json = open('data/genres.json', encoding='utf-8')
    genres_list = json.load(genres_json)

    pprint(movie_info(movies_list, genres_list))
