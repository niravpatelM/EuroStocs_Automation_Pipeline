pipeline {
  agent {
		label 'Windows_Node'
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
        echo "directAutosLogin_1748  Execution Started!!"
        bat 'directAutosLogin_1748.bat'
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
      }
    }
  }

}
