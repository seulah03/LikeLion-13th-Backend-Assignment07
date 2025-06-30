package com.likelion.basecode.common.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorCode {

    // 404
    MEMBER_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 사용자가 없습니다. memberId = ", "NOT_FOUND_404"),
    POST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다. postId = ", "NOT_FOUND_404"),
    TAG_RECOMMENDATION_EMPTY(HttpStatus.BAD_REQUEST, "추천 가능한 태그가 없습니다.", "TAG_RECOMMENDATION_EMPTY_400"),
    TRAVEL_API_NO_RESULT(HttpStatus.NOT_FOUND, "해당 키워드로 검색된 여행지가 없습니다.", "TRAVEL_API_NO_RESULT_400"),

    // 500
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "내부 서버 에러가 발생했습니다", "INTERNAL_SERVER_ERROR_500"),
    TRAVEL_API_RESPONSE_NULL(HttpStatus.INTERNAL_SERVER_ERROR, "여행지 API 응답이 null입니다.", "TRAVEL_API_500"),
    TRAVEL_API_BODY_MALFORMED(HttpStatus.INTERNAL_SERVER_ERROR, "여행지 API의 body 항목이 잘못되었습니다.", "TRAVEL_API_500"),
    TRAVEL_API_ITEMS_MALFORMED(HttpStatus.INTERNAL_SERVER_ERROR, "여행지 API의 items 항목이 잘못되었습니다.", "TRAVEL_API_500"),
    TRAVEL_API_ITEM_MALFORMED(HttpStatus.INTERNAL_SERVER_ERROR, "여행지 API의 item 항목이 잘못되었습니다.", "TRAVEL_API_500"),
    S3_UPLOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 업로드에 실패했습니다.", "S3_UPLOAD_FAIL_500"),
    S3_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "S3 파일 삭제 실패", "S3_DELETE_FAIL_500"),
    IMAGE_NOT_FOUND_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,"삭제할 이미지가 없습니다.", "IMAGE_NOT_FOUND_EXCEPTION_500"),

    // 400 BAD REQUEST
    VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "유효성 검사에 실패하였습니다.", "BAD_REQUEST_400");

    private final HttpStatus httpStatus;
    private final String message;
    private final String code;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
