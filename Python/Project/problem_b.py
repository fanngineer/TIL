import json
from pprint import pprint


def movie_info(movie, genres):
    pass 
    #데이터 추출
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
    return new_data

if __name__ == '__main__':
    movie_json = open('data/movie.json', encoding='utf-8')
    movie = json.load(movie_json)

    genres_json = open('data/genres.json', encoding='utf-8')
    genres_list = json.load(genres_json)

    pprint(movie_info(movie, genres_list))
