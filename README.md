Drugs Project API

How to start application in docker container:
1. clone the repo -> git clone https://github.com/mtlon/drugsProject.git
2. run cmd command inside drugsProject folder -> mvn install
3. run docker build -> docker build . -t drugs-project-api-image
4. start container -> docker run -p 8000:8080 drugs-project-api-image

API will start on http://localhost:8000
