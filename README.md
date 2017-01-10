Projet PDF EPSI

But : faire une application en JAVA permettant de traiter des fichiers PDF, et effectuer divers traitements dessus.

Fonctionnalités :
- Ouvrir un pdf
- Afficher un pdf
- Enregistrer un pdf
- Extraire des pages d'un pdf
- Fusionner (joindre) deux pdf, l'un à la suite de l'autre



CLI :
open {filename}								// ouvre le fichier
save [{filename}]							// enregistre le fichier
show {filename} [{page}]					// affiche le pdf à la page indiquée
join {first pdf} {second pdf} {output}		// joint 2 pdf
split {filename} {start} [{end}]			// extrait certaines pages d'un pdf