FROM maven:3.6.3-jdk-8
RUN mkdir /suitesocial
WORKDIR /suitesocial
COPY . /suitesocial
COPY entrypoint.sh /
RUN chmod +x /entrypoint.sh
EXPOSE 8080
ENTRYPOINT ["/entrypoint.sh"]
CMD ["build"]