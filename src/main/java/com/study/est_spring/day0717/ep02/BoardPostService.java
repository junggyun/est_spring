package com.study.est_spring.day0717.ep02;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardPostService {
    List<BoardPost> boardPosts = new ArrayList<>();
    private Long nextBoardPostId = 1L;
    private Long nextCommentId = 1L;

    public BoardPostDto createBoardPost(BoardPostDto boardPostDto) {
        BoardPost boardPost = convertToBoardPostEntity(boardPostDto);
        boardPost.setId(nextBoardPostId++);
        boardPost.setCreatedAt(LocalDateTime.now());
        boardPosts.add(boardPost);
        return convertToBoardPostDto(boardPost);
    }

    public List<BoardPostDto> getAllBoardPosts() {
        return boardPosts.stream()
            .map(this::convertToBoardPostDto)
            .collect(Collectors.toList());
    }

    public void deleteBoardPost(Long id) {
        BoardPost boardPost = findBoardPostById(id);
        boardPosts.remove(boardPost);
    }

    public BoardPostDto getBoardPostDtoById(Long id) {
        return boardPosts.stream()
            .filter(b -> b.getId().equals(id))
            .findFirst()
            .map(this::convertToBoardPostDto)
            .orElseThrow(IllegalArgumentException::new);
    }



    private BoardPost findBoardPostById(Long id) {
        return boardPosts.stream()
            .filter(post->post.getId().equals(id))
            .findFirst()
            .orElseThrow(()->new IllegalArgumentException("id에 해당하는 글을 찾을 수 없습니다."));
    }

    public BoardPostDto updateBoardPost(Long id, BoardPostDto updateBoardPostDto) {
        BoardPost boardPost = findBoardPostById(id);
        boardPost.setTitle(updateBoardPostDto.getTitle());
        boardPost.setAuthor(updateBoardPostDto.getAuthor());
        boardPost.setContent(updateBoardPostDto.getContent());
        boardPost.setUpdatedAt(LocalDateTime.now());
        boardPost.setComments(updateBoardPostDto.getComments().stream()
            .map(this::convertToCommentEntity)
            .collect(Collectors.toList()));
        return convertToBoardPostDto(boardPost);
    }

    public CommentDto createComment(Long postId, CommentDto commentDto) {
        BoardPost boardPost = findBoardPostById(postId);
        Comment comment = convertToCommentEntity(commentDto);
        comment.setId(nextCommentId++);
        comment.setCreatedAt(LocalDateTime.now());
        boardPost.addComment(comment);

        return convertToCommentDto(comment);
    }

    public void deleteComment(Long postId, Long commentId) {
        BoardPost boardPost = findBoardPostById(postId);
        Comment comment = findCommentByIdAndBoardPost(commentId, boardPost);
        boardPost.removeComment(comment);
    }

    private Comment findCommentByIdAndBoardPost(Long commentId, BoardPost boardPost) {
        return boardPost.getComments().stream()
            .filter(c -> c.getId().equals(commentId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("id에 해당하는 댓글을 찾을 수 없습니다."));
    }

    //==변환 로직==//

    private BoardPost convertToBoardPostEntity(BoardPostDto boardPostDto) {
        BoardPost boardPost = new BoardPost();
        boardPost.setTitle(boardPostDto.getTitle());
        boardPost.setContent(boardPostDto.getContent());
        boardPost.setAuthor(boardPostDto.getAuthor());
        boardPost.setCreatedAt(boardPostDto.getCreatedAt());
        boardPost.setUpdatedAt(boardPostDto.getUpdatedAt());
        if (boardPostDto.getComments() != null) {
            boardPostDto.getComments().forEach(commentDto -> {
                Comment comment = convertToCommentEntity(commentDto);
                comment.setBoardPost(boardPost);
                boardPost.addComment(comment);
            });
        }
        return boardPost;
    }

    private BoardPostDto convertToBoardPostDto(BoardPost boardPost) {
        BoardPostDto boardPostDto = new BoardPostDto();
        boardPostDto.setId(boardPost.getId());
        boardPostDto.setTitle(boardPost.getTitle());
        boardPostDto.setContent(boardPost.getContent());
        boardPostDto.setAuthor(boardPost.getAuthor());
        boardPostDto.setCreatedAt(boardPost.getCreatedAt());
        boardPostDto.setUpdatedAt(boardPost.getUpdatedAt());
        if (boardPost.getComments() != null) {
            boardPostDto.setComments(
                    boardPost.getComments().stream()
                            .map(this::convertToCommentDto)
                            .collect(Collectors.toList())
            );
        }
        return boardPostDto;
    }

    private Comment convertToCommentEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setAuthor(commentDto.getAuthor());
        comment.setContent(commentDto.getContent());
        comment.setCreatedAt(commentDto.getCreatedAt());

        return comment;
    }

    private CommentDto convertToCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setContent(comment.getContent());
        commentDto.setCreatedAt(comment.getCreatedAt());

        return commentDto;
    }
}
