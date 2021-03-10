pipeline {
  agent {
		label 'Windows_Node'
		label 'master'
	} 
  stages {
    stage('Chekout') {
      steps {
        echo "Compile !!"
        git 'https://github.com/gtlniravpatel/EuroStocs_Automation_Pipeline.git'
      }
    }

    stage('Non-Parallel Stage Checking: FullSuitesExecution Execution') {
      agent {
        label "master"
      }
      steps {
        echo "euroStocksAddVehicleBackend_1587 Execution Started!!"
        bat 'euroStocksAddVehicleBackend_1587.bat'
      }
    }

    stage('Run Tests') {
      parallel {

        stage('Test On Windows : directAutosLogin_1748') {
          agent {
            label "Windows_Node"
          }
          steps {
            echo "directAutosLogin_1748 Execution Started!!"
            bat 'directAutosLogin_1748.bat'
          }

        }
        stage('Test On Master: euroStocksLoginForgot_1567') {
          agent {
            label "master"
          }
          steps {
            echo "euroStocksLoginForgot_1567 Execution Started!!"
            bat 'euroStocksLoginForgot_1567.bat'
          }
        }
        stage('Test On Windows : euroStocksAddProductBackend_1586') {
          agent {
            label "Windows_Node"
          }
          steps {
            echo "euroStocksAddProductBackend_1586 Execution Started!!"
            bat 'euroStocksAddProductBackend_1586.bat'
          }

        }
        stage('Test On Master: euroStocksAddVehicleBackend_1587') {
          agent {
            label "master"
          }
          steps {
            echo "euroStocksAddVehicleBackend_1587 Execution Started!!"
            bat 'euroStocksAddVehicleBackend_1587.bat'
          }
        }

      }
    }
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if success'
    }
    failure {
      echo 'This will run only if failed'
    }
    unstable {
      echo 'This will run only if unstable'
    }
    changed {
      echo 'This will run only if Changes'
      echo 'failure and success now'
    }
  }
}