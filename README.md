# 가상화 / 자동화 / 클라우드 기반 보안 네트워크 및 인프라 구현
프로젝트 기간 : 23.06.12 ~ 23.06.22

프로젝트 목표 

- 네트워크 단에서는 공유 Office의 네트워크 통신망을 구현
- Jenkins Pipeline을 지속적 통합/배포 프로세스 구성
- Grafana / Prometheus를 이용한 효율적인 클라우드 리소스 관리를 위한 모니터링 툴 구성


이번 프로젝트에서는  한 분야의 기술 뿐만이 아닌 다양한 네트워크 기술과 시스템의 흐름을 파악하기 위해 현대적인 다양한 기술들을 사용하여 구현했습니다. 

## 프로젝트 구성도
![image](https://github.com/hweyoung/jenkins-gradle/assets/76817418/ffd76677-d2c9-44ef-a40e-17d9f831f05e)
네트워크 통신망이 구성된 PC에서 개발자의 커밋을 통해 애플리케이션의 배포와 모니터링까지 자동화할 수 있도록 구성됩니다. 

## Jenkins Pipeline
![image](https://github.com/hweyoung/jenkins-gradle/assets/76817418/47600257-201b-460c-9556-458f25c9c1b3)
Jenkins는 CI/CD(Continuous Integration/Continuous Deployment)도구로서, 코드 변경 사항을 지속적으로 통합하고 배포하는 자동화 프로세스를 구축하는데 사용됩니다.

Ansible은 인프라 스트럭처 자동화 도구로, YAML 기반의 선언적인 구성 관리를 제공하며 Dokcer 컨테이너를 구성하고 배포하는 데 사용됩니다.

Ansible 서버에서는 ansible playbook을 사용하여 Docker 이미지 빌드를 자동화하고, kubernetes 에서 컨테이너를 실행하고 관리합니다.

ansible은 EKS클러스터의 리소스를 관리하며 배포 매니페스트를 작성하여 애플리케이션을 EKS에 배포합니다.

AWS의 서비스인 EKS는 k8s(kubenetes) 클러스터를 구성하고 관리하며 애플리케이션의 컨테이너화와 오케스트레이션을 담당합니다. k8s 클러스터는 Amazon Web Service 상의 Elastic Kubernetes Service로 구성되며 마이크로 서비스 아키텍처에 기반한 애플리케이션을 실행하고 관리합니다.

## kubernetes cluster 모니터링을 위한 Grafana & Prometheus
![image](https://github.com/hweyoung/jenkins-gradle/assets/76817418/9e94f2e8-95f2-4eed-a97b-b21879a71442)
Grafana란 메트릭, 로그 등을 모니터링 하고 분석할 수 있는 오픈소스 시각 및 분석 툴로, Prometheus나 Cloud Watch 등의 데이터 수집 툴과 연결하여 다양한 형태의 그래프로 시각화 해주는 분석 툴입니다. 

Prometheus란 쿠버네티스 내장 도구인 cAdvisor에서 컨테이너 매트릭을 수집하는 데이터 수집 툴입니다. 

클러스터를 모니터링하기 위해 k8s와 같은 클러스터에 배포했습니다. 

k8s 클러스터에 배포된 Prometheus와 Grafana 모니터링 툴은 데이터 수집과 시각화를 통해 파드들을 운용, 감시하여 실시간에 가까운 장애 대응을 가능케 합니다.


