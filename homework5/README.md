Для запуска приложения необходимо поднять образ postgres в докере:

docker run --name gb_hw5 -e POSTGRES_PASSWORD=pass -p 5433:5432 -d postgres