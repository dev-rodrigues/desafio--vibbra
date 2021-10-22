# VIBBRA 

Esse projeto fornece uma série de apis organizadas em microsserviços com o intuido de lidar com profissionais que atuam em uma rede de indicação de trabalhos freelance.
Nele você encontrará as seguintes APIS:

[] Deal
[] Bid
[] Message
[] Delivery
[] User

## Uso:
Acesse o diretório *entregável*
```bash
docker-compose up
```

Todas as apis estão configurados o */swagger-ui-custom.html*.


```bash
## cadastro deal
curl -X POST \
  http://localhost:8081/deal \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: ee1f9e40-9373-4d70-173d-f4058a03c276' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "type": {
    "type": "Venda"
  },
  "value": 990,
  "description": "New Macbook m1 pro 64gb ram",
  "trade_for": "message trade for",
  "location": {
    "lat": 100,
    "lng": 90,
    "address": "Rua Rio Grande 392",
    "city": "Sao Paulo",
    "state": "Sao Paulo",
    "zip_code": 22740361
  },
  "urgency": {
    "type": "Baixa",
    "limit_date": "2021-10-12"
  },
  "photos": [
    "123123123123"
  ]
}'
```

```bash
## get deal by id
curl -X GET \
  http://localhost:8081/deal/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 80f9deed-1b4b-0283-d487-17695175c04e' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2MTA3MzksImlhdCI6MTYzNDYxMDQzOSwianRpIjoiYzU3NjEwODQtYjU3Yi00YWUzLWFkZmItYWI0MGE2ZjBjYTVhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImI1ZjBmMTg0LTk1OTEtNDg3OC1hMzA3LWM0YmYxNmEwNWFjMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1pcmFuYSIsInByZWZlcnJlZF91c2VybmFtZSI6Im1pcmFuYSIsImdpdmVuX25hbWUiOiJtaXJhbmEiLCJlbWFpbCI6Im1pcmFuYUBlbWFpbC5jb20ifQ.U7mtq6Npl5xzcbAzlEJtrL6MWIAfpqZlg_oFI-wKhpadWMCNGwV1nkPuJPWCZL8FU9V5ojSPpVMNYe8qDlf_crBD7zyXkN3AbqTHPpM2GKZuqpgIHXBoL74ox7IpV8u_kKXqyzqlaXUkI9Rmz6pyWVgkLYvSIzaxitcD2SJyqpU1tDmKciSWGJPRO3jbbFFJseFZtbtzbPwHZjqFMEZdWvzFhurgokC37OJszzIqe7mSi5Tv70f1WVrfUEGrIH1cAtgaUTlmaTPXGJDbVVnEjkbq6SjK48sEKQDAE39odamk-8JME1mu0zdchBckbh_t1nJrwzgUhAeJ7WVurKul4g'
```

```bash
## list all deals
curl -X GET \
  http://localhost:8081/deal/ \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 99dcbedd-938c-2452-caf3-3696967b5103' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMzNTgsImlhdCI6MTYzNDY5MzA1OCwianRpIjoiYjVkZTk5OTItOGVkNy00YzhmLWFkMWUtYjRlNDIzOGU5MDVmIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImI3YTRmZTdmLWVlOWEtNDBkOC04ZTJkLWE1ZWM5YmJkYTFmNSIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6IjUwZDE2NmFiLWQ0ZDAtNDAwZi04MDBmLTZlOTljNTAyNzlmMiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6IjUwZDE2NmFiLWQ0ZDAtNDAwZi04MDBmLTZlOTljNTAyNzlmMiIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1vbml0b3IiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtb25pdG9yIiwiZ2l2ZW5fbmFtZSI6Im1vbml0b3IiLCJ1c2VySWQiOjMsImVtYWlsIjoibW9uaXRvckBlbWFpbC5jb20ifQ.b6wBBjrtJsc4jqgnfNnCzCtBGxwmkgAgK8PIRl0QYcZE1HGgOSOJVwP5iCyz-9pnPFd9dG1mCICSN3gov1BSwo22mngkdNoqD2_r3deD4eal6Y71Fw5JuBoCRsaElqaP9wvfI2-eEpDsle4ZHVAJ5vhIMrMIiQmhFzeJ8Pwrf4XMN0OzOqixN9bignPrE5fni9JDttaspf_qMDb44PYzcJ4or2cr9nImJg5gsjvlw6tRT27NnoCdw3EZGbtSf3TzWHQlcTWvuqHv6GImqLNOzkhNmxDXKNbMrkrQSpU25kPGgcjzm3UPODcvFFtIZE5ZWQ-_7N6ONTB6oylTDDJMTQ'
```

```bash
##edit one deal by id
curl -X PUT \
  'http://localhost:8081/deal?id=1' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: 71ea6afc-7bd5-29cb-588d-bf5a07cc1343' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "type": {
    "type": "Venda"
  },
  "value": 0,
  "description": "string",
  "trade_for": "string",
  "location": {
    "lat": 0,
    "lng": 0,
    "address": "string",
    "city": "string",
    "state": "string",
    "zip_code": 0
  },
  "urgency": {
    "type": "Baixa",
    "limit_date": "2021-10-13"
  },
  "photos": [
    "string"
  ]
}'
```


```bash
## bids of deal
curl -X GET \
  http://localhost:8083/api/v1/deals/1/bids \
  -H 'cache-control: no-cache' \
  -H 'postman-token: a1f821e5-88b2-d8bd-2581-d50ba606c65b'
```

```bash
## create on bid of deal
curl -X POST \
  http://localhost:8083/api/v1/deals/1/bids \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: d6c4415a-4af7-eeb4-0f5f-4a59a7588fb6' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "user_id": 1230,
  "accepted": true,
  "value": 990,
  "description": "pago por pix"
}'
```


```bash
## edit one bid of deal
curl -X PUT \
  'http://localhost:8083/api/v1/deals/1/bids?idBid=2' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: ebd63686-6231-2edf-4119-30c5034af5ad' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "user_id": 330,
  "accepted": false,
  "value": 9990,
  "description": "description"
}'
```

```bash
##get bid of deal
curl -X GET \
  http://localhost:8083/api/v1/deals/1/bids/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 504de362-088a-8a5d-c615-de44c24ba960'
```

```bash
##get messages for deal
curl -X GET \
  http://localhost:8082/api/v1/deals/1/message \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 59d03a2c-b91e-73fa-91d9-e3eadc49ffe5'
```

```bash
##get one message by id for deal
curl -X GET \
  http://localhost:8082/api/v1/deals/1/message/1 \
  -H 'cache-control: no-cache' \
  -H 'postman-token: d54637a9-c7ab-e883-4da9-182719ac7df5'
```

```bash
## create an message of deal
curl -X POST \
  'http://localhost:8082/api/v1/deals/message/?idDeal=1' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: dbec25e0-c7eb-e0a6-b947-ba735b10c69c' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "user_id": 1230,
  "title": "string",
  "message": "string"
}'
```

```bash
## edit one message for deal
curl -X PUT \
  http://localhost:8082/api/v1/deals/1/message/1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -H 'postman-token: cd106fe4-5b99-3573-e8d0-bc8480514fc5' \
  -H 'token: eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ6ZFBzcVByd0JwQWhqNGl4aC1tanVsaFRyZENaRW44N2tERHZrWDB1dUlBIn0.eyJleHAiOjE2MzQ2OTMwNzEsImlhdCI6MTYzNDY5Mjc3MSwianRpIjoiYTZiY2ZhMDUtYzE5Yy00NWE3LWI1YjMtZmYwNjI5YTkxZDc1IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImE4OWM4MjQxLTIyOGUtNDVhNC04ZGM4LTRmNDExMGNlMzA4NiIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImMxNWQwMDAzLTI2ZWYtNDlkMy1hZDY3LTMxZjk4Y2JiNmZlNCIsInppcENvZGUiOiIyMjIyMjIyMiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1hcm1pdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJtYXJtaXRhIiwiZ2l2ZW5fbmFtZSI6Im1hcm1pdGEiLCJ1c2VySWQiOjEsImVtYWlsIjoibWFybWl0YUBlbWFpbC5jb20ifQ.KOJgOCWSxsGZ-TNd7R4Jo_QNRF8QMCJg4tGvIs-rTAO29IH9QZtjGXYHln6P5l32BEYB57H7mWAQlVfc6hnVP6mLta2TXieGiumVuoxEdVmpit3AwWtwKf8RtQ0FkvHnzkPhUSZHjgN0OJaqZKktsloP26keDCtPfrsV_rJO7x3OY_PsHHppDiBTw96mvuqOVihAnS1B5W9NEjvPlqBzJqElvqzIBrSKDBXlEjtWUUVAPfCvfxElepohPbJptifpNcl0cuhnXcsGotY1WEnZTIFVgl7zeQrlepUlgw2rP8omiztV0yPI4Bt6tiUq9CJ4YLv92PZP5FbYVSVVYfxz6Q' \
  -d '{
  "user_id": 123,
  "title": "string",
  "message": "string"
}'
```

```bash
## delivery
curl -X GET \
  'http://localhost:8084/delivery?cepOrigem=22740361&cepDestino=04018001' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 304e0a1d-1128-6900-7ddd-dc2af36f5c76' \
  -H 'token: eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCIsImtpZCI6InpkUHNxUHJ3QnBBaGo0aXhoLW1qdWxoVHJkQ1pFbjg3a0REdmtYMHV1SUEifQ.eyJleHAiOjE2MzQ2MTA3MzksImlhdCI6MTYzNDYxMDQzOSwianRpIjoiYzU3NjEwODQtYjU3Yi00YWUzLWFkZmItYWI0MGE2ZjBjYTVhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2NsaWVudGVzIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImI1ZjBmMTg0LTk1OTEtNDg3OC1hMzA3LWM0YmYxNmEwNWFjMCIsInR5cCI6IkJlYXJlciIsImF6cCI6InRlc3RlIiwic2Vzc2lvbl9zdGF0ZSI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtY2xpZW50ZXMiXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHVzZXIgcHJvZmlsZSIsInNpZCI6ImY3MjA2MTY1LTg5YTQtNDc2OS1hN2I0LWViMjc5OTVjZWExNiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Im1pcmFuYSIsInByZWZlcnJlZF91c2VybmFtZSI6Im1pcmFuYSIsImdpdmVuX25hbWUiOiJtaXJhbmEiLCJlbWFpbCI6Im1pcmFuYUBlbWFpbC5jb20ifQ.YFh_LNiltvUgdXGSrCrpWpsSalMjPJEzWT6XFvbYJygo-eAPT0jesBvZqOTV9hFv9It23EvuNIdrB0LDa_Ucow'
```


URL VIDEO EXPLICANDO O FUNCIONAMENTO DO PROJETO
```
https://youtu.be/rhBkWRlfSh8
```






