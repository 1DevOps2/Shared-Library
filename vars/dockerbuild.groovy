/* groovylint-disable-next-line NoDef */
/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def login() {
    /* groovylint-disable-next-line LineLength */
    withCredentials([usernamePassword(credentialsId: 'hub.docker', usernameVariable: 'hubUsername', passwordVariable: 'hubPassword')]) {
        sh """
            docker login --username="${hubUsername}" --password="${hubPassword}"
        """
    }
}

/* groovylint-disable-next-line FactoryMethodName, MethodReturnTypeRequired, NoDef */
def build(String tag) {
    sh """
        docker build -t "${tag}" .
    """
}

/* groovylint-disable-next-line MethodReturnTypeRequired, NoDef */
def push(String tag) {
    sh """
        docker push "${tag}"
    """
}
