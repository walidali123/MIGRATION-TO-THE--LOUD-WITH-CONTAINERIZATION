FROM php:7-apache
MAINTAINER Dare dare@darey.io

ENV MYSQL_IP=172.18.0.2:3306
ENV MYSQL_USER=walid
ENV MYSQL_PASS=walid
ENV MYSQL_DBNAME=toolingdb

RUN docker-php-ext-install mysqli
RUN echo "ServerName localhost" >> /etc/apache2/apache2.conf
RUN curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
COPY apache-config.conf /etc/apache2/sites-available/000-default.conf
COPY start-apache /usr/local/bin
RUN a2enmod rewrite

# Copy application source
COPY html /var/www
RUN chown -R www-data:www-data /var/www

CMD ["start-apache"]
