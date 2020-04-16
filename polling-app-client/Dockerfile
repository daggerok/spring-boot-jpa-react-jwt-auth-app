# Stage 1: Build the react application
FROM library/node:13.13.0-alpine3.11 as builder
WORKDIR /app

# dependencies will be cached unless changes to one of those two files are made.
COPY package.json package-lock.json ./
RUN npm install -E
RUN npm audit fix

COPY . .
ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=${REACT_APP_API_BASE_URL}
RUN npm run build

# Stage 2: Serve the React application from Nginx
FROM library/nginx:1.17.9-alpine
EXPOSE 80
ENTRYPOINT ["/bin/ash", "-c"]
CMD ["nginx -g 'daemon off;'"]
COPY                ./nginx.conf /etc/nginx/nginx.conf
COPY --from=builder /app/build   /var/www
