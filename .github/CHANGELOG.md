- 大幅提升视频列表的加载速度，打开应用后视频信息更快呈现
- 视频缩略图现在优先使用系统服务加载，浏览列表时图片显示更加迅速流畅
- 对于系统无法生成缩略图的特殊格式视频，自动使用内置解码器生成预览图，确保所有视频都有封面
- 修复部分视频时长显示为 0:00 的问题，现在所有视频都能正确显示完整时长
- 修复从文件管理器或其他应用打开的视频无法显示时长和缩略图的问题
- 从外部应用打开的视频现在也会自动获取并展示完整的视频信息
- 大幅提升播放器启动速度，例如 6GB 大文件从原先近一分钟的等待缩短至一两秒即可开始播放
- 修复下拉刷新偶尔卡住不动的问题，现在刷新操作始终能正常完成
- 改进对本地视频文件的发现能力，手动添加的视频路径也能被正确识别和管理
- 通过文件管理器等方式打开的视频现在能更可靠地被应用接管并播放
- 修复竖屏观看视频时字幕位置偏移的问题，字幕现在始终显示在画面范围内
- 竖屏模式下字幕不再溢出到视频画面之外，观看体验更加舒适
- 最低系统版本要求提升至 Android 11，带来更稳定的运行表现和更小的安装体积
- 移除大量旧版本兼容代码，应用运行更高效，占用资源更少

<details>
<summary>English Version</summary>

- Significantly improved video list loading speed — video info appears faster after opening the app
- Video thumbnails now load using system services first, making list browsing smoother and faster
- For special format videos where system thumbnails are unavailable, the built-in decoder automatically generates preview images so every video has a cover
- Fixed an issue where some videos showed a duration of 0:00 — all videos now display their correct full duration
- Fixed videos opened from file managers or other apps not showing duration or thumbnails
- Videos opened from external apps now automatically fetch and display complete video information
- Dramatically improved player startup speed — for example, a 6GB video that previously took nearly a minute to load now starts playing in just one to two seconds
- Fixed an occasional issue where pull-to-refresh would get stuck — refresh now always completes properly
- Improved local video file discovery — manually added video paths are now correctly recognized and managed
- Videos opened via file managers or similar apps are now more reliably handled and played by the app
- Fixed subtitle positioning offset when watching videos in portrait mode — subtitles now always stay within the video area
- Subtitles in portrait mode no longer overflow outside the video frame, providing a more comfortable viewing experience
- Minimum system requirement raised to Android 11, delivering more stable performance and a smaller install size
- Removed a large amount of legacy compatibility code, resulting in a more efficient app with lower resource usage

</details>