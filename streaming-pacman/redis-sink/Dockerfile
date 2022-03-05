FROM golang:1.16.14

LABEL maintainer="Ricardo Ferreira <riferrei@riferrei.com>"

WORKDIR /redis-sink
COPY go.mod .
COPY redis-sink.go .
RUN go build -o redis-sink .

CMD ["./redis-sink"]