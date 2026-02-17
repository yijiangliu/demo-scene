FROM golang:1.26.0

LABEL maintainer="Ricardo Ferreira <riferrei@riferrei.com>"

WORKDIR /redis-sink
COPY go.mod .
COPY redis-sink.go .
RUN go build -o redis-sink .

CMD ["./redis-sink"]