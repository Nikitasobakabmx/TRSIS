FROM postgres:9.4
EXPOSE 5432
COPY initDB.sql /docker-entrypoint-initdb.d/myInitionalDB.sql
ENV POSTGRES_USER nikittossii
ENV POSTGRES_PASSWORD 111261
ENV POSTGRES_DB shop
ENV PGDATA=/data
