// Fonction pour afficher/masquer la barre latérale
function toggleSidebar() {
    const sidebar = document.getElementById('sidebar');
    sidebar.classList.toggle('active');
}

// Fonction pour charger les Acteurs
function loadActors() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active'); // Supprimer la classe active des autres boutons
    });
    document.querySelectorAll('.sidebar ul li button')[0].classList.add('active'); // Ajouter la classe active au bouton "Acteurs"

    fetch('/actors')
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Acteurs</h2>
                <button onclick="openModal()" class="create-btn">Ajouter un acteur</button>
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Biographie</th>
                            <th>URL Photo</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(actor => `
                            <tr>
                                <td>${actor.name}</td>
                                <td>${actor.biography}</td>
                                <td><a href="${actor.photoUrl}" target="_blank">${actor.photoUrl}</a></td>
                                <td>
                                    <button onclick="editActor(${actor.id})" class="edit-btn">Modifier</button>
                                    <button onclick="deleteActor(${actor.id})" class="delete-btn">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

// Fonction pour afficher le modal de création ou modification
function openModal() {
    document.getElementById('actorModal').style.display = 'block';
    document.getElementById('modalTitle').innerText = "Ajouter un Acteur";
    document.getElementById('actorForm').setAttribute("data-id", ""); // Réinitialiser l'ID pour la création
    document.getElementById('submitButton').innerText = 'Créer';
}

// Fonction pour fermer le modal
function closeModal() {
    document.getElementById('actorModal').style.display = 'none';
}

// Fonction pour remplir le modal avec les données d'un acteur pour modification
function editActor(id) {
    fetch(`/actors/${id}`)
        .then(response => response.json())
        .then(actor => {
            document.getElementById('actorModal').style.display = 'block';
            document.getElementById('modalTitle').innerText = "Modifier l'Acteur";
            document.getElementById('name').value = actor.name;
            document.getElementById('biography').value = actor.biography;
            document.getElementById('photoUrl').value = actor.photoUrl;
            document.getElementById('actorForm').setAttribute("data-id", actor.id);
            document.getElementById('submitButton').innerText = 'Mettre à jour';
        });
}

// Fonction pour supprimer un acteur
function deleteActor(id) {
    if (confirm("Voulez-vous vraiment supprimer cet acteur ?")) {
        fetch(`/actors/${id}`, {
            method: 'DELETE'
        }).then(() => loadActors()); // Recharger la liste des acteurs après suppression
    }
}

// Fonction pour soumettre le formulaire (création ou mise à jour)
function submitForm(event) {
    event.preventDefault(); // Empêcher la soumission par défaut du formulaire
    const form = document.getElementById('actorForm');

    const actorData = {
        name: document.getElementById('name').value,
        biography: document.getElementById('biography').value,
        photoUrl: document.getElementById('photoUrlActor').value
    };

    let actionUrl = "/actors";
    let method = "POST";

    const actorId = form.getAttribute("data-id");
    if (actorId) {
        actionUrl = `/actors/${actorId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(actorData)
    }).then(response => {
        if (response.ok) {
            closeModal();
            loadActors();
        } else {
            alert("Une erreur est survenue.");
        }
    });
}







// Fonction pour charger les Catégories
function loadCategories() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active');
    });
    document.querySelectorAll('.sidebar ul li button')[1].classList.add('active');

    fetch('/api/categories')
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Catégories</h2>
                <button onclick="openCategoryModal()" class="create-btn">Ajouter une catégorie</button>
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(category => `
                            <tr>
                                <td>${category.name}</td>
                                <td>${category.description}</td>
                                <td>
                                    <button class="edit-btn" onclick="editCategory(${category.id})">Modifier</button>
                                    <button class="delete-btn" onclick="deleteCategory(${category.id})">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

// Ouvrir le modal de création/modification
function openCategoryModal() {
    document.getElementById('categoryModal').style.display = 'block';
    document.getElementById('modalCategoryTitle').innerText = "Ajouter une Catégorie";
    document.getElementById('categoryForm').setAttribute("data-id", "");
    document.getElementById('categorySubmitButton').innerText = 'Créer';
}

// Fermer le modal
function closeCategoryModal() {
    document.getElementById('categoryModal').style.display = 'none';
}

// Modifier une catégorie
function editCategory(id) {
    fetch(`/api/categories/${id}`)
        .then(response => response.json())
        .then(category => {
            document.getElementById('categoryModal').style.display = 'block';
            document.getElementById('modalCategoryTitle').innerText = "Modifier la Catégorie";
            document.getElementById('name').value = category.name;
            document.getElementById('description').value = category.description;
            document.getElementById('categoryForm').setAttribute("data-id", category.id);
            document.getElementById('categorySubmitButton').innerText = 'Mettre à jour';
        });
}

// Supprimer une catégorie
function deleteCategory(id) {
    if (confirm("Voulez-vous vraiment supprimer cette catégorie ?")) {
        fetch(`/api/categories/${id}`, {
            method: 'DELETE'
        }).then(() => loadCategories());
    }
}

// Soumettre le formulaire
function submitCategoryForm(event) {
    event.preventDefault();
    const form = document.getElementById('categoryForm');

    const categoryData = {
        name: document.getElementById('categoryName').value,
        description: document.getElementById('categoryDescription').value
    };

    let actionUrl = "/api/categories";
    let method = "POST";

    const categoryId = form.getAttribute("data-id");
    if (categoryId) {
        actionUrl = `/api/categories/${categoryId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(categoryData)
    }).then(response => {
        if (response.ok) {
            closeCategoryModal();
            loadCategories();
        } else {
            alert("Une erreur est survenue.");
        }
    });
}




// Fonction pour charger les Thèmes
function loadThemes() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active');
    });
    document.querySelectorAll('.sidebar ul li button')[2].classList.add('active');

    fetch('/api/themes') // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Thèmes</h2>
                <button onclick="openThemeModal()" class="create-btn">Ajouter un Thème</button>
                <table>
                    <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(theme => `
                            <tr>
                                <td>${theme.name}</td>
                                <td>${theme.description}</td>
                                <td>
                                    <button class="edit-btn" onclick="editTheme(${theme.id})">Modifier</button>
                                    <button class="delete-btn" onclick="deleteTheme(${theme.id})">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

// Ouvrir le modal de création/modification
function openThemeModal() {
    document.getElementById('themeModal').style.display = 'block';
    document.getElementById('modalThemeTitle').innerText = "Ajouter un Thème";
    document.getElementById('themeForm').setAttribute("data-id", "");
    document.getElementById('themeSubmitButton').innerText = 'Créer';
}

// Fermer le modal
function closeThemeModal() {
    document.getElementById('themeModal').style.display = 'none';
}

// Modifier un thème
function editTheme(id) {
    fetch(`/api/themes/${id}`) // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(theme => {
            document.getElementById('themeModal').style.display = 'block';
            document.getElementById('modalThemeTitle').innerText = "Modifier le Thème";
            document.getElementById('themeName').value = theme.name;
            document.getElementById('themeDescription').value = theme.description;
            document.getElementById('themeForm').setAttribute("data-id", theme.id);
            document.getElementById('themeSubmitButton').innerText = 'Mettre à jour';
        });
}

// Supprimer un thème
function deleteTheme(id) {
    if (confirm("Voulez-vous vraiment supprimer ce thème ?")) {
        fetch(`/api/themes/${id}`, { // ✅ Correction de l'URL API
            method: 'DELETE'
        }).then(() => loadThemes());
    }
}

// Soumettre le formulaire (création ou mise à jour)
function submitThemeForm(event) {
    event.preventDefault();
    const form = document.getElementById('themeForm');

    const themeData = {
        name: document.getElementById('themeName').value,
        description: document.getElementById('themeDescription').value
    };

    let actionUrl = "/api/themes"; // ✅ Correction de l'URL API
    let method = "POST";

    const themeId = form.getAttribute("data-id");
    if (themeId) {
        actionUrl = `/api/themes/${themeId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(themeData)
    }).then(response => {
        if (response.ok) {
            closeThemeModal();
            loadThemes();
        } else {
            alert("Une erreur est survenue.");
        }
    });
}








// Fonction pour charger les News
function loadNews() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active');
    });
    document.querySelectorAll('.sidebar ul li button')[3].classList.add('active');

    fetch('/api/news') // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des News</h2>
                <button onclick="openNewsModal()" class="create-btn">Ajouter une News</button>
                <table>
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Auteur</th>
                            <th>Date de publication</th>
                            <th>Contenu</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
<tbody>
    ${data.map(news => `
        <tr>
            <td>${news.title}</td>
            <td>${news.author}</td>
            <td>${news.publishDate}</td>
            <td>${news.content}</td>
            <td>${news.category}</td> <!-- ✅ Ajout de la catégorie -->
            <td>
                <button class="edit-btn" onclick="editNews(${news.id})">Modifier</button>
                <button class="delete-btn" onclick="deleteNews(${news.id})">Supprimer</button>
            </td>
        </tr>
    `).join('')}
</tbody>
                </table>
            `;
        });
}

// Ouvrir le modal de création/modification
function openNewsModal() {
    document.getElementById('newsModal').style.display = 'block';
    document.getElementById('modalNewsTitle').innerText = "Ajouter une News";
    document.getElementById('newsForm').setAttribute("data-id", "");
    document.getElementById('newsSubmitButton').innerText = 'Créer';
}

// Fermer le modal
function closeNewsModal() {
    document.getElementById('newsModal').style.display = 'none';
}

// Modifier une News
function editNews(id) {
    fetch(`/api/news/${id}`) // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(news => {
            document.getElementById('newsModal').style.display = 'block';
            document.getElementById('modalNewsTitle').innerText = "Modifier la News";
            document.getElementById('newsTitle').value = news.title;
            document.getElementById('newsContent').value = news.content;
            document.getElementById('newsAuthor').value = news.author;
            document.getElementById('newsPublishDate').value = news.publishDate;
            document.getElementById('newsCategory').value = news.category;
            document.getElementById('newsForm').setAttribute("data-id", news.id);
            document.getElementById('newsSubmitButton').innerText = 'Mettre à jour';
        });
}

// Supprimer une News
function deleteNews(id) {
    if (confirm("Voulez-vous vraiment supprimer cette news ?")) {
        fetch(`/api/news/${id}`, { // ✅ Correction de l'URL API
            method: 'DELETE'
        }).then(() => loadNews());
    }
}

// Soumettre le formulaire (création ou mise à jour)
function submitNewsForm(event) {
    event.preventDefault();
    const form = document.getElementById('newsForm');

    const newsData = {
        title: document.getElementById('newsTitle').value,
        content: document.getElementById('newsContent').value,
        author: document.getElementById('newsAuthor').value,
        publishDate: document.getElementById('newsPublishDate').value,
        category: document.getElementById('newsCategory').value
    };

    let actionUrl = "/api/news"; // ✅ Correction de l'URL API
    let method = "POST";

    const newsId = form.getAttribute("data-id");
    if (newsId) {
        actionUrl = `/api/news/${newsId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newsData)
    }).then(response => {
        if (response.ok) {
            closeNewsModal();
            loadNews();
        } else {
            alert("Une erreur est survenue.");
        }
    });
}






// Fonction pour charger les Tv_movies
function loadTvMovies() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active');
    });

    const tvMoviesButton = Array.from(document.querySelectorAll('.sidebar ul li button'))
        .find(button => button.textContent.trim() === 'Tv Movies');
    if (tvMoviesButton) {
        tvMoviesButton.classList.add('active');
    }

    fetch('/api/tv-movies') // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Tv Movies</h2>
                <button onclick="openTvMovieModal()" class="create-btn">Ajouter un Tv Movie</button>
                <table>
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Durée</th>
                            <th>URL Trailer</th>
                            <th>URL du Film</th>
                            <th>Part</th>
                            <th>Catégorie</th>
                            <th>Thème</th>
                            <th>Évaluation</th>
                            <th>Description</th>
                            <th>Photo</th> <!-- ✅ Ajout -->
                            <th>Date de Sortie</th> <!-- ✅ Ajout -->
                            <th>Réalisateur</th> <!-- ✅ Ajout -->
                            <th>Société de Production</th> <!-- ✅ Ajout -->
                            <th>Catégorie d'âge</th> <!-- ✅ Ajout -->
                            <th>Langue</th> <!-- ✅ Ajout -->
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(tvMovie => `
                            <tr>
                                <td>${tvMovie.title}</td>
                                <td>${tvMovie.duration}</td>
                                <td><a href="${tvMovie.trailerUrl}" target="_blank">${tvMovie.trailerUrl}</a></td>
                                <td><a href="${tvMovie.movieUrl}" target="_blank">${tvMovie.movieUrl}</a></td>
                                <td>${tvMovie.part}</td>
                                <td>${tvMovie.category ? tvMovie.category.name : ''}</td>
                                <td>${tvMovie.theme ? tvMovie.theme.name : ''}</td>
                                <td>${tvMovie.rating}</td>
                                <td>${tvMovie.description}</td>
                                <td><img src="${tvMovie.photoUrl}" width="50" height="50"></td>
                                <td>${tvMovie.releaseDate}</td>
                                <td>${tvMovie.director}</td>
                                <td>${tvMovie.productionCompany}</td>
                                <td>${tvMovie.categoryAge}</td>
                                <td>${tvMovie.language}</td>
                                <td>
                                    <button onclick="editTvMovie(${tvMovie.id})" class="edit-btn">Modifier</button>
                                    <button onclick="deleteTvMovie(${tvMovie.id})" class="delete-btn">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

// Ouvrir le modal de création/modification
function openTvMovieModal(tvMovie = {}) {
    document.getElementById('tvMovieModal').style.display = 'block';
    document.getElementById('modalTvMovieTitle').innerText = tvMovie.id ? "Modifier le Tv Movie" : "Ajouter un Tv Movie";
    document.getElementById('tvMovieForm').setAttribute("data-id", tvMovie.id || "");

    // Remplir le formulaire avec les données existantes
    document.getElementById('tvMovieTitle').value = tvMovie.title || '';
    document.getElementById('duration').value = tvMovie.duration || '';
    document.getElementById('trailerUrl').value = tvMovie.trailerUrl || '';
    document.getElementById('movieUrl').value = tvMovie.movieUrl || '';
    document.getElementById('part').value = tvMovie.part || '';
    document.getElementById('rating').value = tvMovie.rating || '';
    document.getElementById('description').value = tvMovie.description || '';
    document.getElementById('photoUrl').value = tvMovie.photoUrl || '';
    document.getElementById('releaseDate').value = tvMovie.releaseDate || '';
    document.getElementById('director').value = tvMovie.director || '';
    document.getElementById('productionCompany').value = tvMovie.productionCompany || '';
    document.getElementById('categoryAge').value = tvMovie.categoryAge || '';
    document.getElementById('language').value = tvMovie.language || '';

    loadCategoriesInForm();
    loadThemesInForm();
}

// Soumettre le formulaire (création ou mise à jour)
function submitTvMovieForm(event) {
    event.preventDefault();

    const tvMovieData = {
        title: document.getElementById('tvMovieTitle').value,
        duration: document.getElementById('duration').value,
        trailerUrl: document.getElementById('trailerUrl').value,
        movieUrl: document.getElementById('movieUrl').value,
        part: document.getElementById('part').value,
        rating: document.getElementById('rating').value,
        description: document.getElementById('description').value,
        photoUrl: document.getElementById('photoUrl').value,
        releaseDate: document.getElementById('releaseDate').value,
        director: document.getElementById('director').value,
        productionCompany: document.getElementById('productionCompany').value,
        categoryAge: document.getElementById('categoryAge').value,
        language: document.getElementById('language').value
    };

    let actionUrl = "/api/tv-movies";
    let method = "POST";

    const tvMovieId = document.getElementById('tvMovieForm').getAttribute("data-id");
    if (tvMovieId) {
        actionUrl = `/api/tv-movies/${tvMovieId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(tvMovieData)
    }).then(response => {
        if (response.ok) {
            closeTvMovieModal();
            loadTvMovies();
        } else {
            alert("Une erreur est survenue.");
        }
    });
}


// Fonction pour fermer le modal
function closeTvMovieModal() {
    document.getElementById('tvMovieModal').style.display = 'none';
}


// Fonction pour charger les catégories et les ajouter au formulaire
function loadCategoriesInForm() {
    fetch('/api/categories') // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(categories => {
            const categorySelect = document.getElementById('category');
            categorySelect.innerHTML = ''; // Réinitialiser la liste des catégories
            categories.forEach(category => {
                const option = document.createElement('option');
                option.value = category.id; // L'ID de la catégorie est utilisé comme valeur
                option.textContent = category.name; // Afficher le nom de la catégorie
                categorySelect.appendChild(option);
            });
        });
}

// Fonction pour charger les thèmes et les ajouter au formulaire
function loadThemesInForm() {
    fetch('/api/themes') // ✅ Correction de l'URL API
        .then(response => response.json())
        .then(themes => {
            const themeSelect = document.getElementById('theme');
            themeSelect.innerHTML = ''; // Réinitialiser la liste des thèmes
            themes.forEach(theme => {
                const option = document.createElement('option');
                option.value = theme.id; // L'ID du thème est utilisé comme valeur
                option.textContent = theme.name; // Afficher le nom du thème
                themeSelect.appendChild(option);
            });
        });
}

// Modifier un Tv_movie
function editTvMovie(id) {
    fetch(`/api/tv-movies/${id}`)
        .then(response => {
            if (!response.ok) {
                throw new Error("Erreur lors du chargement du Tv Movie");
            }
            return response.json();
        })
        .then(tvMovie => {
            console.log("Données reçues du backend :", tvMovie); // ✅ Vérification

            // Vérification que chaque champ est bien récupéré
            document.getElementById('tvMovieTitle').value = tvMovie.title || '';
            document.getElementById('duration').value = tvMovie.duration || 0;
            document.getElementById('trailerUrl').value = tvMovie.trailerUrl || '';
            document.getElementById('movieUrl').value = tvMovie.movieUrl || '';
            document.getElementById('part').value = tvMovie.part || '';
            document.getElementById('rating').value = tvMovie.rating || 0;
            document.getElementById('description').value = tvMovie.description || '';
            document.getElementById('photoUrl').value = tvMovie.photoUrl || '';
            document.getElementById('releaseDate').value = tvMovie.releaseDate || '';
            document.getElementById('director').value = tvMovie.director || '';
            document.getElementById('productionCompany').value = tvMovie.productionCompany || '';
            document.getElementById('categoryAge').value = tvMovie.categoryAge || '';
            document.getElementById('language').value = tvMovie.language || '';
            document.getElementById('category').value = tvMovie.category ? tvMovie.category.id : '';
            document.getElementById('theme').value = tvMovie.theme ? tvMovie.theme.id : '';

            openTvMovieModal(tvMovie);
        })
        .catch(error => alert(error.message));
}

// Supprimer un Tv_movie
function deleteTvMovie(id) {
    if (confirm("Voulez-vous vraiment supprimer ce Tv Movie ?")) {
        fetch(`/api/tv-movies/${id}`, { method: 'DELETE' }) // ✅ Correction de `POST` en `DELETE`
            .then(response => {
                if (!response.ok) {
                    throw new Error("Erreur lors de la suppression du Tv Movie");
                }
                loadTvMovies(); // ✅ Recharge la liste après suppression
            })
            .catch(error => alert(error.message)); // ✅ Ajout d'une gestion d'erreur
    }
}









// Fonction pour charger les Episodes
function loadEpisodes() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active'); // Supprimer la classe active des autres boutons
    });

    const episodesButton = Array.from(document.querySelectorAll('.sidebar ul li button'))
        .find(button => button.textContent.trim() === 'Episodes');
    if (episodesButton) {
        episodesButton.classList.add('active'); // Ajouter la classe active
    }

    fetch('/api/episodes') // ✅ Correction de l'endpoint
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Episodes</h2>
                <button onclick="openEpisodeModal()" class="create-btn">Ajouter un Episode</button>
                <table>
                    <thead>
                        <tr>
                            <th>Numéro d'Episode</th>
                            <th>Titre</th>
                            <th>Saison</th>
                            <th>TV Show</th> <!-- ✅ Ajout du TV Show -->
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(episode => `
                            <tr>
                                <td>${episode.episodeNumber}</td>
                                <td>${episode.title}</td>
                                <td>${episode.seasonNumber || ''}</td>
                                <td>${episode.tvShowId ? `TV Show #${episode.tvShowId}` : ''}</td> <!-- ✅ Ajout -->
                                <td>
                                    <button onclick="editEpisode(${episode.id})" class="edit-btn">Modifier</button>
                                    <button onclick="deleteEpisode(${episode.id})" class="delete-btn">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

function openEpisodeModal(episode = {}) {
    document.getElementById('episodeModal').style.display = 'block';
    document.getElementById('modalEpisodeTitle').innerText = episode.id ? "Modifier l'Episode" : "Ajouter un Episode";
    document.getElementById('episodeForm').action = episode.id ? `/api/episodes/${episode.id}` : '/api/episodes';
    document.getElementById('episodeSubmitButton').innerText = episode.id ? 'Mettre à jour' : 'Créer';

    document.getElementById('episodeNumber').value = episode.episodeNumber || '';
    document.getElementById('episodeTitle').value = episode.title || '';
    document.getElementById('episodeDescription').value = episode.description || '';
    document.getElementById('episodePhotoUrl').value = episode.photoUrl || '';
    document.getElementById('episodeDuration').value = episode.duration || '';
    document.getElementById('episodeVideoUrl').value = episode.videoUrl || '';

    // Si l'épisode a un TV Show, préremplir la valeur, sinon mettre "Aucun"
    document.getElementById('episodeTvShow').value = episode.tvShowId || ''; // ✅ Gère l'absence de TV Show

    loadTvShowsInEpisodeForm(); // Charger les TV Shows dynamiquement
}

// Fonction pour fermer le modal de Episode
function closeEpisodeModal() {
    document.getElementById('episodeModal').style.display = 'none';
}

// Fonction pour soumettre le formulaire d'Episode (création ou mise à jour)
function submitEpisodeForm(event) {
    event.preventDefault();

    const episodeData = {
        episodeNumber: document.getElementById('episodeNumber').value,
        title: document.getElementById('episodeTitle').value,
        description: document.getElementById('episodeDescription').value,
        photoUrl: document.getElementById('episodePhotoUrl').value,
        duration: document.getElementById('episodeDuration').value,
        videoUrl: document.getElementById('episodeVideoUrl').value,
        seasonNumber: document.getElementById('episodeSeason').value,
        tvShowId: document.getElementById('episodeTvShow').value // ✅ Ajout du TV Show
    };

    let actionUrl = "/api/episodes";
    let method = "POST";

    const episodeId = document.getElementById('episodeForm').getAttribute("data-id");
    if (episodeId) {
        actionUrl = `/api/episodes/${episodeId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(episodeData)
    }).then(response => response.json())
        .then(() => {
            closeEpisodeModal();
            loadEpisodes();
        })
        .catch(error => alert("Erreur lors de la mise à jour : " + error.message));
}

// Fonction pour éditer un Episode
function editEpisode(id) {
    fetch(`/api/episodes/${id}`)
        .then(response => response.json())
        .then(episode => {
            openEpisodeModal(episode); // Ouvre le modal avec les informations de l'épisode
        });
}

// Fonction pour supprimer un Episode
function deleteEpisode(id) {
    if (confirm("Voulez-vous vraiment supprimer cet Episode ?")) {
        fetch(`/api/episodes/${id}`, { method: 'DELETE' }) // ✅ Correction du `POST` en `DELETE`
            .then(() => loadEpisodes());
    }
}


// Fonction pour charger les TV Shows dans le formulaire d'Episode
function loadTvShowsInEpisodeForm() {
    fetch('/api/tvshows')
        .then(response => response.json())
        .then(tvShows => {
            console.log("TV Shows chargés :", tvShows); // ✅ Debug pour voir si les données arrivent bien

            const tvShowSelect = document.getElementById('episodeTvShow');
            tvShowSelect.innerHTML = '';

            const defaultOption = document.createElement('option');
            defaultOption.value = '';
            defaultOption.textContent = "Aucun TV Show"; // ✅ Ajout d’une option vide
            tvShowSelect.appendChild(defaultOption);

            tvShows.forEach(tvShow => {
                const option = document.createElement('option');
                option.value = tvShow.id;
                option.textContent = tvShow.title;
                tvShowSelect.appendChild(option);
            });

            console.log("Options TV Show ajoutées :", tvShowSelect.innerHTML); // ✅ Vérifier si les options sont bien ajoutées
        })
        .catch(error => {
            console.error("Erreur de chargement des TV Shows :", error);
        });
}










// Fonction pour charger les TV Shows
function loadTvShows() {
    document.querySelectorAll('.sidebar ul li button').forEach(button => {
        button.classList.remove('active'); // Supprimer la classe active des autres boutons
    });

    const tvShowsButton = Array.from(document.querySelectorAll('.sidebar ul li button'))
        .find(button => button.textContent.trim() === 'TV Shows');
    if (tvShowsButton) {
        tvShowsButton.classList.add('active'); // Ajouter la classe active
    }

    fetch('/api/tv-shows') // ✅ Correction de l'endpoint
        .then(response => response.json())
        .then(data => {
            const contentArea = document.getElementById('contentArea');
            contentArea.innerHTML = `
                <h2>Liste des Séries TV</h2>
                <button onclick="openTvShowModal()" class="create-btn">Ajouter une TV Show</button>
                <table>
                    <thead>
                        <tr>
                            <th>Titre</th>
                            <th>Évaluation</th>
                            <th>Catégorie d'âge</th>
                            <th>Langue</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${data.map(tvShow => `
                            <tr>
                                <td>${tvShow.title}</td>
                                <td>${tvShow.rating || 'N/A'}</td>
                                <td>${tvShow.categoryAge || 'N/A'}</td>
                                <td>${tvShow.language || 'N/A'}</td>
                                <td>
                                    <button onclick="editTvShow(${tvShow.id})" class="edit-btn">Modifier</button>
                                    <button onclick="deleteTvShow(${tvShow.id})" class="delete-btn">Supprimer</button>
                                </td>
                            </tr>
                        `).join('')}
                    </tbody>
                </table>
            `;
        });
}

// Fonction pour afficher le modal de création ou modification d'une TV Show
function openTvShowModal(tvShow = {}) {
    document.getElementById('tvShowModal').style.display = 'block';
    document.getElementById('modalTvShowTitle').innerText = tvShow.id ? "Modifier la TV Show" : "Ajouter une TV Show";
    document.getElementById('tvShowForm').action = tvShow.id ? `/api/tv-shows/${tvShow.id}` : '/api/tv-shows';
    document.getElementById('tvShowSubmitButton').innerText = tvShow.id ? 'Mettre à jour' : 'Créer';

    document.getElementById('tvShowTitle').value = tvShow.title || '';
    document.getElementById('tvShowRating').value = tvShow.rating || '';
    document.getElementById('tvShowDescription').value = tvShow.description || '';
    document.getElementById('tvShowPhotoUrl').value = tvShow.photoUrl || '';
    document.getElementById('tvShowReleaseDate').value = tvShow.releaseDate || '';
    document.getElementById('tvShowDirector').value = tvShow.director || '';
    document.getElementById('tvShowProductionCompany').value = tvShow.productionCompany || '';
    document.getElementById('tvShowCategoryAge').value = tvShow.categoryAge || '';
    document.getElementById('tvShowLanguage').value = tvShow.language || '';

    loadCategoriesInTvShowForm(); // Charger dynamiquement les catégories
    loadThemesInTvShowForm(); // Charger dynamiquement les thèmes
}

// Fonction pour fermer le modal de TV Show
function closeTvShowModal() {
    document.getElementById('tvShowModal').style.display = 'none';
}

// Fonction pour soumettre le formulaire de TV Show (création ou mise à jour)
function submitTvShowForm(event) {
    event.preventDefault();

    const tvShowData = {
        title: document.getElementById('tvShowTitle').value,
        rating: document.getElementById('tvShowRating').value,
        description: document.getElementById('tvShowDescription').value,
        photoUrl: document.getElementById('tvShowPhotoUrl').value,
        releaseDate: document.getElementById('tvShowReleaseDate').value,
        director: document.getElementById('tvShowDirector').value,
        productionCompany: document.getElementById('tvShowProductionCompany').value,
        categoryAge: document.getElementById('tvShowCategoryAge').value,
        language: document.getElementById('tvShowLanguage').value,
        categoryId: document.getElementById('tvShowCategory').value // ✅ Ajout
    };

    let actionUrl = "/api/tv-shows";
    let method = "POST";

    const tvShowId = document.getElementById('tvShowForm').getAttribute("data-id");
    if (tvShowId) {
        actionUrl = `/api/tv-shows/${tvShowId}`;
        method = "PUT";
    }

    fetch(actionUrl, {
        method: method,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(tvShowData)
    }).then(response => response.json())
        .then(() => {
            closeTvShowModal();
            loadTvShows();
        })
        .catch(error => alert("Erreur lors de la mise à jour : " + error.message));
}

// Fonction pour éditer une TV Show
function editTvShow(id) {
    fetch(`/api/tv-shows/${id}`)
        .then(response => response.json())
        .then(tvShow => {
            openTvShowModal(tvShow);
        });
}

// Fonction pour supprimer une TV Show
function deleteTvShow(id) {
    if (confirm("Voulez-vous vraiment supprimer cette TV Show ?")) {
        fetch(`/api/tv-shows/${id}`, { method: 'DELETE' }) // ✅ Correction du `POST` en `DELETE`
            .then(() => loadTvShows());
    }
}

// Fonction pour charger les catégories dans le formulaire de TV Show
function loadCategoriesInTvShowForm() {
    fetch('/api/categories')
        .then(response => response.json())
        .then(categories => {
            const categorySelect = document.getElementById('tvShowCategory');
            categorySelect.innerHTML = '';

            categories.forEach(category => {
                const option = document.createElement('option');
                option.value = category.id;
                option.textContent = category.name;
                categorySelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error("Erreur de chargement des catégories:", error);
        });
}

// Fonction pour charger les thèmes dans le formulaire de TV Show
function loadThemesInTvShowForm() {
    fetch('/api/themes')
        .then(response => response.json())
        .then(themes => {
            const themeSelect = document.getElementById('tvShowTheme');
            themeSelect.innerHTML = '';

            themes.forEach(theme => {
                const option = document.createElement('option');
                option.value = theme.id;
                option.textContent = theme.name;
                themeSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error("Erreur de chargement des thèmes:", error);
        });
}