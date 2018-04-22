FROM mariadb

COPY entrypoint.sh /entrypoint.sh
COPY init.sql /init.sql

RUN chmod +x entrypoint.sh

EXPOSE 3306

ENTRYPOINT ["/entrypoint.sh"]

