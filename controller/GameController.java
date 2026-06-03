package com.example.demo.b5.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {


    @Secured("ROLE_PLAYER")
    @PostMapping("/{gameId}/buy-item")
    public String buyVirtualItem(@PathVariable UUID gameId, @RequestParam String itemId) {
        return "Giao dịch thành công! Vật phẩm " + itemId + " của game " + gameId + " đã được thêm vào kho đồ.";
    }


    @DeleteMapping("/comments/{commentId}")
    @PreAuthorize("hasRole('GAME_MODERATOR') or @commentService.isCommentOwner(#commentId, authentication.name)")
    public String deleteComment(@PathVariable Long commentId) {
        return "Bình luận số " + commentId + " đã được gỡ bỏ thành công (bởi tác giả hoặc Moderator).";
    }


    @PostMapping("/tournament/{roomId}/join")
    @PreAuthorize("hasRole('PLAYER') and #ticketType == 'VIP_TICKET'")
    public String joinVIPTournament(@PathVariable UUID roomId, @RequestParam String ticketType) {
        return "Xác thực vé VIP thành công! Đã kết nối người chơi vào phòng đấu giải: " + roomId;
    }
}