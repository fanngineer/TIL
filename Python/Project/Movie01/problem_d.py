import json


def max_revenue(movies):
    pass 
    # 여기에 코드를 작성합니다.  
    top_revenue = 0
    for movie in movies:
        id = movie['id']
        info_json = open(f'data/movies/{id}.json', encoding='utf-8')
        movie_info = json.load(info_json)    
        revenue = movie_info['revenue']
        if top_revenue < revenue :
            top_revenue = revenue
            top_name = movie['title']
    return top_name
# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='utf-8')
    movies_list = json.load(movies_json)
    
    print(max_revenue(movies_list))
