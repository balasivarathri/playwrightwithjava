pipeline
{
	agent any

    tools{
		maven 'maven'
        }

    stages
    {
		stage('Dev')
        {
			steps
            {
				echo("deploy to SIT")
            }
        }

        stage("SIT"){
			steps
            {
				echo("deploy to UAT")
            }
        }

        stage('UAT') {
			steps {
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
					git 'https://github.com/balasivarathri/playwrightwithjava.git'
                    bat "mvn clean install"
                }
            }
        }
        stage('Publish HTML Report'){
			steps{
				publishHTML([allowMissing: false,
                                  alwaysLinkToLastBuild: false,
                                  keepAll: true,
                                  reportDir: 'target/cucumber-html-reports',
                                  reportName: 'BALA HTML Report',
                                  reportTitles: ''])
            }
        }
    }
}
