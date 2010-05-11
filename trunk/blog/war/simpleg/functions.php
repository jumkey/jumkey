<?php
if ( function_exists('register_sidebar') )
   register_sidebar(array(
	    'before_title' => '<h3>',
        'after_title' => '</h3>',
	)); 
function mytheme_comment($comment, $args, $depth) {
   $GLOBALS['comment'] = $comment; ?>
   <li <?php comment_class('clearfix'); ?> id="comment-<?php comment_ID() ?>" >
    <div id="div-comment-<?php comment_ID(); ?>" class="c">
     	<div class="gravatar"> <?php echo get_avatar( $comment, $size = '35'); ?></div>
   		<div class="comments">
         <div class="commentmetadata"> <?php printf(__('%s'), get_comment_author_link()) ?>:<?php printf(__('%1$s at %2$s'), get_comment_date(),  get_comment_time()) ?> <?php edit_comment_link(__('(Edit)'),'  ','') ?></div>
  

      <div class="reply">
         <?php comment_reply_link(array_merge( $args, array('add_below' => 'div-comment', 'depth' => $depth, 'max_depth' => $args['max_depth']))) ?>
      </div>      
      <?php if ($comment->comment_approved == '0') : ?>
         <em><?php _e('Your comment is awaiting moderation.') ?></em>
         <br />
      <?php endif; ?>
	
      <?php comment_text() ?>
      </div>
</div>
<?php
        }

?>