$(document).ready(function () {

    $('.delete-video').click(function (e) {

        if (!confirm("Вы уверены, что хотите удалить видео?")){
            e.preventDefault();
            // var id = $(this).data('id');
            // $.ajax({
            //     url: 'remove',
            //     data: ({ 'id' : id }),
            //     beforeSend: function(xhr) {
            //         xhr.setRequestHeader("Accept", "application/json");
            //         xhr.setRequestHeader("Content-Type", "application/json");
            //     },
            //     success: function (data) {
            //         console.log(data);
            //     }
            // });
        }
    });

    $('#addVideoModal').on('show.bs.modal', function (event) {
        var $button = $(event.relatedTarget); // Button that triggered the modal
        var recipient = $button.data('id');
        var $modalBtn = $(this).find('.btn-primary');
        var $modalTitle = $(this).find('.modal-title');
        var text = 'Add video',
            videoName = '',
            videoAuthor = '',
            videoURL = '',
            id = 0;

        if (recipient){
            var $element = $button.parents('.video');
            text = 'Edit video';
            videoName = $element.data('name');
            videoAuthor = $element.data('author');
            videoURL = $element.data('url');
            id = recipient;
        }

        $('#videoName').val(videoName);
        $('#videoAuthor').val(videoAuthor);
        $('#videoURL').val(videoURL);
        $('#Id').val(id);
        $modalBtn.text(text);
        $modalTitle.text(text);
    });


    getPagination();

});

function getPagination() {
    var onPage = 3,
        $videos = $('.list .video'),
        videosCount = $videos.length;
    if (videosCount > onPage){
        var pageCount = Math.ceil(videosCount / onPage),
            $pagination = $('.pagination');
        for (var i = 1; i <= pageCount; i++){
            $pagination.append('<li><a class="pagination-item" data-page="' + i + '" href="#">' + i + '</a></li>');
            for (var j = (i - 1)*onPage; j < i*onPage; j++){
                $($videos[j]).attr('data-page', i);
            }
        }

        $('.pagination-item').click(function () {
            $videos.hide();
            $('.pagination-item').removeClass('active');
            $('.list .video[data-page="' + $(this).addClass('active').data('page') + '"').show();
        });
        $('.pagination-item').first().click();
    }
}