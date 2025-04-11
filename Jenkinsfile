pipeline
{
	agent any

    tools{
		maven 'maven'
        }

    stages
    {
		stage('Build')
        {
			steps
            {
				echo("deploy to qa")
            }
        }

        stage("Deploy to QA"){
			steps{
				echo("deploy to qa")
            }
        }

        stage('Regression Automation Test') {
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
                                  reportFiles: 'overview-features.html',
                                  reportName: 'BALA HTML Report',
                                  reportTitles: ''])
            }
        }
    }
}