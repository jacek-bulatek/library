curl -i -H "Accept: application/json" -H "Content-type:application/json" -X POST -d '{"title":"siema","author":"jol"}' "localhost:1234/api/v1/books"
curl -i -H "Accept: application/json" -X GET localhost:1234/api/v1/books
